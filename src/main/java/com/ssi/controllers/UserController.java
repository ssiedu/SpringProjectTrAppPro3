package com.ssi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.dao.CustomerDAO;
import com.ssi.dao.TransporterDAO;
import com.ssi.entities.Customer;
import com.ssi.entities.Transporter;

@Controller
@SessionAttributes(names = { "email", "username" })
public class UserController {

	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private TransporterDAO transporterDAO;

	@RequestMapping("verify")
	public ModelAndView verifyUser(@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("utype") String utype) {

		if (utype.equalsIgnoreCase("admin")) {
			if (email.equals("admin@gmail.com") && password.equals("admin")) {
				ModelAndView mv = new ModelAndView("adminhome");
				mv.addObject("email", email);
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("wronguser");
				return mv;
			}
		} else if (utype.equalsIgnoreCase("customer")) {
			Customer c = new Customer();
			c.setEmail(email);
			c.setPassword(password);
			Customer customer = customerDAO.verifyCustomer(c);
			System.out.println(customer);
			if (customer != null) {
				ModelAndView mv = new ModelAndView("customerhome");
				mv.addObject("email", email);
				mv.addObject("username", customer.getCname());
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("wronguser");
				return mv;
			}

		} else {
			Transporter t = new Transporter();
			t.setEmail(email);
			t.setPassword(password);
			Transporter transporter = transporterDAO.verifyTransporter(t);
			if (transporter != null) {
				ModelAndView mv = new ModelAndView("transporterhome");
				mv.addObject("email", email);
				mv.addObject("username", transporter.getTname());
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("wronguser");
				return mv;
			}

		}
	}
}
