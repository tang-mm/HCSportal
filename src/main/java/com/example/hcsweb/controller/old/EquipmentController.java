package com.example.hcsweb.controller.old;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		JdbcConnector connector = new JdbcConnector();
		Connection conn = connector.getDBConnection("admin", "admin");
		String selectQuery = "SELECT c.customer_id, customer_name, count(*) count FROM customers c, equipment e WHERE c.customer_id != 0 AND c.customer_id = e.customer_id";
		ArrayList<String[]> listCust = new ArrayList<String[]>();
		try {
			ResultSet resultSet = connector.executeSelect(conn, selectQuery);
			while (resultSet.next()) {
				String custId = resultSet.getString("c.customer_id");
				String custName = resultSet.getString("customer_name");
				String count = resultSet.getString("count");
				System.out.println(custId + "\t" + custName + "\t" + count);
				listCust.add(new String[] { custId, custName, count });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listCustomer", listCust);
		return new ModelAndView("Equipment/manageEquipment");
	}

	@RequestMapping(value = "listEquipment", method = RequestMethod.GET)
	public ModelAndView listEquipment(HttpServletRequest request) {
		System.out.println("********[EquipmentController] list equipment********");
		int custId = Integer.parseInt(request.getParameter("custId"));
		String custName = request.getParameter("custName");
		JdbcConnector connector = new JdbcConnector();
		Connection conn = connector.getDBConnection("admin", "admin");
		// TODO return only the 10 first results, update with pagination
		String selectQuery = "SELECT * FROM equipment WHERE customer_id =" + custId;
		ArrayList<Equipment> listEquip = new ArrayList<Equipment>();
		try {
			ResultSet resultSet = connector.executeSelect(conn, selectQuery);
			while (resultSet.next()) {
				int equipId = Integer.parseInt(resultSet.getString("equipment_id"));
				String equipName = resultSet.getString("equipment_name");
				String ip = resultSet.getString("ip_address");
				String serial = resultSet.getString("serial_number");
				String machine = resultSet.getString("machine_type");
				boolean isVirt = resultSet.getBoolean("is_virtualized");
				String os = resultSet.getString("operating_system");
				String app = resultSet.getString("app_version");
				String hardware = resultSet.getString("hardware");
				String location = resultSet.getString("geo_location");
				System.out.println(equipId + "\t" + equipName);
				listEquip.add(new Equipment(equipId, equipName, ip, serial, machine,
						isVirt, os, app, hardware, location));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ModelAndView model = new ModelAndView("Equipment/listEquipment");
		model.addObject("custName", custName);
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