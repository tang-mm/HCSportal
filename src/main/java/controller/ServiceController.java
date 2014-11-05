package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.Customer;
import model.Service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceController {

	
	@RequestMapping(value="manageServices", method=RequestMethod.GET)
	public ModelAndView showListServices(HttpServletRequest request) {
		System.out.println("********[ServiceController] show service list********");
		
		boolean isExpert = Boolean.parseBoolean((String) request.getSession().getAttribute("isExpert")); 
		if (!isExpert) {
			//TODO get customer ID
			String customerName = null;
			int customerId = 0;
			request.setAttribute("customerId", customerId);
			request.setAttribute("customerName", customerName);
			
			ArrayList<Service> listService = new ArrayList<Service>();
			
			request.setAttribute("listService", listService);
		}
		
		request.setAttribute("isExpert", isExpert);
		
		return new ModelAndView("Service/listService");
	}
	
	@RequestMapping(value="serviceDetails", method=RequestMethod.GET) 
	public ModelAndView showServiceDetails(HttpServletRequest request) {
		System.out.println("********[ServiceController] show service details********");
		
		String serviceId = request.getParameter("serviceId");
		//TODO retrieve row from DB
		Service service = new Service();
		request.setAttribute("service", service);
		
		return new ModelAndView("Service/serviceDetails");
	}
	
	@RequestMapping(value="createNewService", method=RequestMethod.GET)
	public ModelAndView createNewService() {

		System.out.println("********[ServiceController] create new service********");
		ModelAndView model = new ModelAndView("Service/newService", "newServiceCmd", new Service());
		return model;
	}
	
	@RequestMapping(value="submitNewService", method=RequestMethod.POST)
	public ModelAndView submitNewService(@ModelAttribute Service service) {

		ModelAndView model = new ModelAndView("Service/newService", "newServiceCmd", service);
		 
			//TODO add into database  
		
		 model.addObject("message", "Successfully added new service!");
		
		return model;
	}
}
