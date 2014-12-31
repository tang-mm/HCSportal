package com.example.hcsweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.hcsweb.model.Customer;
import com.example.hcsweb.model.Equipment;
import com.example.hcsweb.model.Tenant;
import com.example.hcsweb.service.EquipmentService;
import com.example.hcsweb.service.TenantService;
 
@Controller
public class EquipmentController {
	@Autowired
	private EquipmentService equipService;
	@Autowired
	private TenantService tenantService;

	@RequestMapping(value = "manageEquipment", method = RequestMethod.GET)
	public ModelAndView showCustomerEquipment(HttpServletRequest request) {
		System.out.println("********[EquipmentController] manage equipment********");
		
		// show list customer - tenant for Experts
		List<Tenant> listTenant = tenantService.getAllTenants();
		request.setAttribute("listTenant", listTenant);
		return new ModelAndView("Equipment/manageEquipment");
	
	}


	@RequestMapping(value = "listEquipment", method = RequestMethod.GET)
	public ModelAndView listEquipment(HttpServletRequest request) {
		System.out.println("********[EquipmentController] list equipment********");
		int tenantId = Integer.parseInt(request.getParameter("tenantId"));
		String tenantName = request.getParameter("tenantName");

		List<Equipment> listEquip = equipService.findEquipmentByTenantId(tenantId);
		ModelAndView model = new ModelAndView("Equipment/listEquipment");
		model.addObject("tenantName", tenantName);
		model.addObject("listEquip", listEquip);
		return model;
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
