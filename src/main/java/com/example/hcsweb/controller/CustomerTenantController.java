package com.example.hcsweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.hcsweb.model.Customer;
import com.example.hcsweb.service.CustomerService;

@Controller
public class CustomerTenantController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "manageCustomers", method = RequestMethod.GET)
	public ModelAndView listCustomers(HttpServletRequest request) {
		System.out.println("********[CostumerController] manage customers********");

		boolean isAdmin = Boolean.parseBoolean((String) request.getSession().getAttribute("isAdmin"));
		System.out.println("admin: " + isAdmin); 
		if (!isAdmin) { // Expert: retrieve list of customers and tenants

			List<Customer> listCustomer = customerService.getAllCustomers();

			ModelAndView model = new ModelAndView("UserAdmin/manageCustomersExpert");
			model.addObject("listCustomer", listCustomer);
			return model;
		} else { // customer admin: retrieve list of tenants

			ModelAndView model = new ModelAndView("UserAdmin/manageCustomersCust");
			ArrayList<String[]> listTenant = new ArrayList<String[]>();

			model.addObject("listTenant", listTenant);
			return model;
		}
	}
}