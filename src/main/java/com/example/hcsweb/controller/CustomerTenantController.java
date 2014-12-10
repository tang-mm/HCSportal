package com.example.hcsweb.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.hcsweb.model.Customer;
import com.example.hcsweb.model.Tenant;
import com.example.hcsweb.model.users.User;
import com.example.hcsweb.service.CustomerService;
import com.example.hcsweb.service.TenantService;

@Controller
public class CustomerTenantController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private TenantService tenantService;

	@RequestMapping(value = "manageCustomers", method = RequestMethod.GET)
	public ModelAndView listCustomers(HttpServletRequest request) {
		System.out.println("********[CostumerController] manage customers********");

		boolean isAdmin = Boolean.parseBoolean((String) request.getSession().getAttribute(
				"isCustAdmin"));
		System.out.println("admin: " + isAdmin);
		if (!isAdmin) { // Expert: retrieve list of customers and tenants

			List<Customer> listCustomer = customerService.getAllCustomers();

			ModelAndView model = new ModelAndView("CustAdmin/manageCustomersExpert");
			model.addObject("listCustomer", listCustomer);
			return model;
		} else { // customer admin: retrieve list of tenants

			ModelAndView model = new ModelAndView("CustAdmin/manageCustomersCust");
			ArrayList<String[]> listTenant = new ArrayList<String[]>();

			model.addObject("listTenant", listTenant);
			return model;
		}
	}

	@RequestMapping(value = "manageTenants", method = RequestMethod.GET)
	public ModelAndView listTenants(HttpServletRequest request) {
		// for CustAdmin
		User user = (User) request.getSession().getAttribute("currentUser");
		List<Tenant> listTenant = user.getListTenant();

		ModelAndView model = new ModelAndView("CustAdmin/manageTenant");
		model.addObject("listTenant", listTenant);
		return model;
	}

	@RequestMapping(value = "createNewCustomer", method = RequestMethod.GET)
	public ModelAndView createNewCustomer() {
		System.out.println("********[CostumerController] create new customer********");
		Customer customer = new Customer();
		Tenant newTenant = new Tenant();
		newTenant.setCustomer(customer);

		ModelAndView model = new ModelAndView("CustAdmin/newCustomer", "newCustomerCmd", customer);
		model.addObject("newTenantCmd", newTenant);
		// model.addObject("IPaddress", "controller: new customer");
		return model;
	}

	@RequestMapping(value = "submitNewCustomer", method = RequestMethod.POST)
	public ModelAndView submitNewCustomer(@ModelAttribute Customer customer) {
		System.out.println("********[CostumerController] submit new customer********");
		// TODO Validate fields: not null, IP format
		try {
			int custId = customer.getCustomerId();
			Customer custInDB = customerService.findCustomerById(custId);
			String newName = customer.getCustomerName();
			if (!custInDB.getCustomerName().equalsIgnoreCase(newName)) {
				custInDB.setCustomerName(newName);
			}
			String newDesc = customer.getDescription();
			if (!custInDB.getDescription().equalsIgnoreCase(newDesc)) {
				custInDB.setDescription(newDesc);
			}
			customerService.saveCustomer(custInDB);
		} catch (Exception e) {
			ModelAndView model = new ModelAndView("CustAdmin/newCustomer", "newCustomerCmd",
					customer);
			model.addObject("messageCustomer",
					"Unable to create customer. Please check the information entered!");
			return model;
		}
		ModelAndView model = new ModelAndView("CustAdmin/customerDetails", "customerCmd", customer);
		Tenant tenant = new Tenant();
		tenant.setCustomer(customer);
		model.addObject("newTenantCmd", tenant);
		model.addObject("messageCustomer", "Successfully added new customer!");
		model.addObject("success", true);
		return model;
	} 

	@RequestMapping(value = "addTenantToList", method = RequestMethod.POST)
	public @ResponseBody List<Tenant> submitNewTenant(HttpServletRequest request, @RequestParam String custId) {
		System.out.println("********[CostumerController] add new tenant to list********");
		String tenantName = request.getParameter("tenantName");
		String ipMain = request.getParameter("ipMain");
		String desc = request.getParameter("description");
		
		Tenant tenant = new Tenant(tenantName, ipMain, desc);

		int custIdInt = Integer.parseInt(custId);
		Customer custInDB = customerService.findCustomerById(custIdInt);
		List<Tenant> list = custInDB.getListTenant();
		list.add(tenant);

		custInDB.setListTenant(list);
		customerService.saveCustomer(custInDB);

		return list;
	}

	@RequestMapping(value = "removeTenantFromList", method = RequestMethod.GET)
	public Customer deleteNewTenant(HttpServletRequest request,	@ModelAttribute Customer customer) {
		System.out.println("********[CostumerController] delete new tenant from list********");
//		ModelAndView model = new ModelAndView("CustAdmin/customerDetails");
		String tenantName = request.getParameter("name");
		// find tenant from list and delete
		List<Tenant> listT = customer.getListTenant();
		for (Tenant t : listT) {
			if (t.getTenantName().equalsIgnoreCase(tenantName))
				listT.remove(t);
		}
		customer.setListTenant(listT);
//		model.addObject("customerCmd", customer);
//		model.addObject("newTenantCmd", new Tenant());
//		model.addObject("modifying",true);	// to be used to deactivate "modify" button

		return customer;
	}

	@RequestMapping(value = "customerDetails", method = RequestMethod.GET)
	public ModelAndView showCustomerDetails(HttpServletRequest request) {
		String custName = request.getParameter("customer");
		ModelAndView model = new ModelAndView("CustAdmin/customerDetails");
		model.addObject("newTenantCmd", new Tenant());
		try {
			Customer cust = customerService.findCustomerByName(custName);
			model.addObject("customerCmd", cust);
		} catch (HibernateException e) {
			model.addObject("customerCmd", new Customer());
			model.addObject("message", "Error in finding customer");
		}
		return model;

	}

	@RequestMapping(value = "customerDetails", method = RequestMethod.POST)
	public ModelAndView modifyCustomerDetails(HttpServletRequest request,
			@ModelAttribute Customer customer) {

		ModelAndView model = new ModelAndView("CustAdmin/customerDetails", "customerCmd", customer);
		model.addObject("newTenantCmd", new Tenant());
		try {
			customerService.saveCustomer(customer);
			model.addObject("messageCustomer", "Update with success.");
		} catch (Exception e) {
			model.addObject("messageCustomer", "Error updating customer");
		}
		return model;
	}

}