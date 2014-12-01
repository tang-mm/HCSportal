package com.example.hcsweb.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.hcsweb.model.Customer;
import com.example.hcsweb.model.Tenant;
import com.exony.schemas._2009._10.resourcemanagement.NameValuePair;
import com.exony.schemas._2009._10.resourcemanagement.Resource;

@Controller
public class CostumerController {
	
	@RequestMapping(value = "manageCustomers", method = RequestMethod.GET)
	public ModelAndView listCustomers(HttpServletRequest request) {
		System.out.println("********[CostumerController] manage customers********");

		boolean isAdmin = Boolean.parseBoolean((String) request.getSession().getAttribute("isAdmin"));
		if (!isAdmin) { // Expert: retrieve list of customers and tenants
			ArrayList<String[]> listTenant = new ArrayList<String[]>();
			ArrayList<String[]> listCustomer = new ArrayList<String[]>();

			try {
				CcdmManager ccdm = new CcdmManager();
				List<Resource> searchResult = ccdm.retrieveTenants();
				int idxTenantName = -1;
				int idxParentOwnerName = -1;
				int idxCreationDate = -1;
				int idxModifiedDate = -1;
				// retrieve field names
				ArrayList<NameValuePair> listPair = (ArrayList<NameValuePair>) searchResult.get(0).getFields()
						.getNameValuePair();
				for (NameValuePair pair : listPair) {
					if (pair.getName().equalsIgnoreCase("Name"))
						idxTenantName = listPair.indexOf(pair);
					if (pair.getName().equalsIgnoreCase("ParentOwnerName"))
						idxParentOwnerName = listPair.indexOf(pair);
					if (pair.getName().equalsIgnoreCase("CreationDate"))
						idxCreationDate = listPair.indexOf(pair);
					if (pair.getName().equalsIgnoreCase("ModifiedDate"))
						idxModifiedDate = listPair.indexOf(pair);
				}
				// retrieve field values
				for (Resource res : searchResult) {
					listPair = (ArrayList<NameValuePair>) res.getFields().getNameValuePair();
					listTenant.add(new String[] { listPair.get(idxTenantName).getValue(),
							listPair.get(idxParentOwnerName).getValue(), listPair.get(idxCreationDate).getValue(),
							listPair.get(idxModifiedDate).getValue() });
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			// TODO remove this line after test
			listTenant.add(new String[] { "testName", "test", "2014-01-01", "2014-01-01" });
			listCustomer.add(new String[] { "customer1", "desc", "2014-01-01", "2014-01-01" });
			listCustomer.add(new String[] { "customer2", "desc", "2014-02-02", "2014-02-02" });

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

	@RequestMapping(value = "createNewCustomer", method = RequestMethod.GET)
	public ModelAndView createNewCustomer() {
		System.out.println("********[CostumerController] create new customer********");
		ModelAndView model = new ModelAndView("UserAdmin/newCustomer", "newCustomerCmd", new Customer());
		model.addObject("newTenantCmd", new Tenant());
		// model.addObject("IPaddress", "controller: new customer");
		return model;
	}
	
	@RequestMapping(value = "submitNewCustomer", method = RequestMethod.POST)
    public ModelAndView submitNewCustomer(@ModelAttribute Customer customer) {
		System.out.println("********[CostumerController] submit new customer********");
		ModelAndView model = new ModelAndView("UserAdmin/newCustomer", "newCustomerCmd", customer);
		//TODO Validate fields: not null, IP format
		
		
		
		JdbcConnector db = new JdbcConnector();
		Connection conn = db.getDBConnection("admin", "admin");
		try {
			db.insertIntoCustomersTable(conn, customer.getCustomerName(), customer.getDescription());
		} catch (SQLException e) {
			model.addObject("message", "Error writing into Database!");
			e.printStackTrace();
			 return model;
		}
		
		 model.addObject("message", "Successfully added new customer!");
		 model.addObject("success", true);
          return model;
    }
	
	@RequestMapping(value = "createNewTenant", method = RequestMethod.POST) 
	public ModelAndView createNewTenant() {
		System.out.println("********[CostumerController] create new tenant********");
		ModelAndView model = new ModelAndView("UserAdmin/newCustomer", "newTenantCmd", new Tenant());
		// model.addObject("IPaddress", "controller: new customer");
		return model;
	}
	
	@RequestMapping(value = "submitNewTenant", method = RequestMethod.POST)
    public ModelAndView submitNewTenant(@ModelAttribute Tenant tenant, @ModelAttribute Customer customer) {
		System.out.println("********[CostumerController] submit new tenant********");
		ModelAndView model = new ModelAndView("UserAdmin/newCustomer", "newTenantCmd", tenant);
//		customer.addNewTenant(tenant);
		model.addObject("newCustomerCmd", customer);
		
		//TODO insert into DB; in view: show newly added tenant
		return model;
	}
}