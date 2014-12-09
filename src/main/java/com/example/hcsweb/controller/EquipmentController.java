package com.example.hcsweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.hcsweb.model.Equipment;
 
@Controller
public class EquipmentController {
	

	@RequestMapping(value = "manageEquipment", method = RequestMethod.GET)
	public ModelAndView showCustomerEquipment(HttpServletRequest request) {
		System.out.println("********[EquipmentController] manage equipment********");
		
		// show list customer - tenant for Experts
		return null;
	
	}


	@RequestMapping(value = "listEquipment", method = RequestMethod.GET)
	public ModelAndView listEquipment(HttpServletRequest request) {
		System.out.println("********[EquipmentController] list equipment********");
		return null;
	}
	
	

	@RequestMapping(value = "equipmentDetails", method = RequestMethod.GET)
	public ModelAndView showEquipmentDetails(HttpServletRequest request) {
		System.out.println("********[EquipmentController] equipment details ********");
		
		int equipId = Integer.parseInt(request.getParameter("equipId"));
		
		// TODO send SQL query
		Equipment equip = new Equipment();
		ModelAndView model = new ModelAndView("Equipment/equipmentDetails");
		model.addObject("equip", equip);
		return model;
	}

	@RequestMapping(value = "searchEquipment", method = RequestMethod.GET)
	public ModelAndView searchEquipment(HttpServletRequest request) {
		System.out.println("********[EquipmentController] search equipment********");
		// TODO send SQL query
		return new ModelAndView("Equipment/searchEquipment");
	}

	@RequestMapping(value = "createNewEquipment", method = RequestMethod.GET)
	public ModelAndView createNewEquipment(HttpServletRequest request) {
		System.out.println("********[EquipmentController] add equipment********");
		// TODO send SQL query
		return new ModelAndView("Equipment/newEquipment");
	}
	
	@RequestMapping(value = "modifyEquipment", method = RequestMethod.GET)
	public ModelAndView modifyEquipment(HttpServletRequest request) {
		System.out.println("********[EquipmentController] modify equipment********");
		// TODO send SQL query
		return new ModelAndView("Equipment/modifyEquipment");
	}
	
	@RequestMapping(value = "deleteEquipment", method = RequestMethod.GET)
	public ModelAndView deleteEquipment(HttpServletRequest request) {
		System.out.println("********[EquipmentController] delete equipment********");
		// TODO send SQL query
		return new ModelAndView();	
	}
}
