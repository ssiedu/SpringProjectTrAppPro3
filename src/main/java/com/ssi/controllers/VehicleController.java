package com.ssi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.dao.VehicleDAO;
import com.ssi.entities.Transporter;
import com.ssi.entities.Vehicle;
import com.ssi.utility.DataProvider;

@Controller
public class VehicleController {

	@Autowired
	private VehicleDAO vehicleDAO;

	@RequestMapping("savevehiclechanges")
	public ModelAndView saveVehicleChanges(@ModelAttribute("vehicle") Vehicle vehicle, @SessionAttribute("email") String email){
		Transporter transporter=new Transporter(); transporter.setEmail(email);
		vehicle.setTransporter(transporter);
		vehicleDAO.updateVehicle(vehicle);
		ModelAndView mv=new ModelAndView("redirect:vehiclelist");
		return mv;
	}
	
	@RequestMapping("updatevehicle")
	public ModelAndView showVehicleUpdateForm(@RequestParam("regno") String regno){
		ModelAndView mv=new ModelAndView("vehicleupdateform");
		Vehicle vehicle=vehicleDAO.getVehicleByRegno(regno);
		mv.addObject("vehicle",vehicle);
		List<String> vtypes=DataProvider.getVehicleTypes();
		List<String> brands=DataProvider.getVehicleBrands();
		mv.addObject("vtypes",vtypes);
		mv.addObject("brands",brands);
		return mv;
	}
	
	
	@RequestMapping("vehiclelist")
	public ModelAndView showVehicleList(@SessionAttribute("email") String email){
		List<Vehicle> vehicles=vehicleDAO.getAllVehicleByTransporter(email);
		ModelAndView mv=new ModelAndView("vehiclelist");
		mv.addObject("vehicles", vehicles);
		return mv;
	}
	
	@RequestMapping("savevehicle")
	public ModelAndView saveVehicleData(@ModelAttribute("vehicle") Vehicle vehicle, @SessionAttribute("email") String email){
		Transporter transporter=new Transporter(); transporter.setEmail(email);
		vehicle.setTransporter(transporter);
		vehicleDAO.saveVehicle(vehicle);
		ModelAndView mv=new ModelAndView("vehiclesaveconfirm");
		return mv;
	}
	@RequestMapping("vehicleentry")
	public ModelAndView showVehicleEntryForm(){
		ModelAndView mv=new ModelAndView("vehicleentry");
		mv.addObject("vehicle", new Vehicle());
		List<String> vtypes=DataProvider.getVehicleTypes();
		List<String> brands=DataProvider.getVehicleBrands();
		mv.addObject("vtypes",vtypes);
		mv.addObject("brands",brands);
		return mv;
	}
	
}
