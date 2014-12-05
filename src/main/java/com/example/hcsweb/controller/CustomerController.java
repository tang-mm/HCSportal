package com.example.hcsweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.hcsweb.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "manageCustomers", method = RequestMethod.GET)
	public ModelAndView listCustomers(HttpServletRequest request) {
		System.out.println("********[CostumerController] manage customers********");
	
		
		return null;

	}
}