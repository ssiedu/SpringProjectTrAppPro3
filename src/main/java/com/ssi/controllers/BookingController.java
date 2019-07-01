package com.ssi.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.dao.BookingDAO;
import com.ssi.dao.VehicleDAO;
import com.ssi.entities.Booking;
import com.ssi.utility.DataProvider;

@Controller
public class BookingController {

	@Autowired
	private VehicleDAO vehicleDAO;
	@Autowired

	private BookingDAO bookingDAO;



	@RequestMapping("citysearch")
	public ModelAndView showSearchCityForm(){
		ModelAndView mv=new ModelAndView("citysearch");
		mv.addObject("booking",new Booking());
		mv.addObject("cities",DataProvider.getCityNames());
		return mv;
	}
	
	@RequestMapping("searchcitybooking")
	public ModelAndView showCitySearchResult(@RequestParam("sourceCity") String from, @RequestParam("destCity") String to){
		List<Booking> bookings=bookingDAO.getAllBookings(from, to);
		ModelAndView mv=new ModelAndView("bookinglistview");
		mv.addObject("bookings",bookings);
		return mv;
		
	}

	
	@RequestMapping("searchdatebooking")
	public ModelAndView showDateSearchResult(@RequestParam("bdate") String bdate){
		List<Booking> bookings=bookingDAO.getAllBookings(bdate);
		ModelAndView mv=new ModelAndView("bookinglistview");
		mv.addObject("bookings",bookings);
		return mv;
		
	}

	
	@RequestMapping("datesearch")
	public String showDateSearchForm(){
		return "datesearch";
	}

	
	@RequestMapping("viewallbookings")
	public ModelAndView showAllBooking(){
		List<Booking> bookings=bookingDAO.getAllBookings();
		ModelAndView mv=new ModelAndView("bookinglistview");
		mv.addObject("bookings",bookings);
		return mv;
	}

	
	@RequestMapping("bookingentry")
	public ModelAndView showBookEntryForm(@SessionAttribute("email") String email){
		ModelAndView mv=new ModelAndView("bookingentryform");
		mv.addObject("booking",new Booking());
		//List<String> regnos=vehicleDAO.getAllRegnos(email);
		Map<String,String> regnos=vehicleDAO.getAllRegnosMap(email);
		List<String> cities=DataProvider.getCityNames();
		mv.addObject("regnos",regnos);
		mv.addObject("cities", cities);
		return mv;
	}
	
	@RequestMapping("savebooking")
	public ModelAndView saveBookingData(@ModelAttribute("booking") Booking booking){
		bookingDAO.saveBooking(booking);
		ModelAndView mv=new ModelAndView("bookingsaveconfirm");
		return mv;
	}

}
