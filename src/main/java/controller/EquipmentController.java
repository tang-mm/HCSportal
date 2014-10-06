package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EquipmentController {
	
	@RequestMapping(value="manageEquipment", method=RequestMethod.GET)
	public ModelAndView showCustomerEquipment(HttpServletRequest request) {
		
		System.out.println("********[EquipmentController] manage equipment********");
		
		// retrieve list of all customers
		return new ModelAndView("Equipment/manageEquipment");
	}
	
	@RequestMapping(value="searchEquipment", method=RequestMethod.GET)
	public ModelAndView searchEquipment(HttpServletRequest request) {
		
		System.out.println("********[EquipmentController] search equipment********");
		
		// send SQL query 
		return new ModelAndView("Equipment/searchEquipment");
	}
} 