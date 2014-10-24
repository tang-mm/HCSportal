package controller;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		
		JdbcConnector connector = new JdbcConnector();
		Connection conn = connector.getDBConnection("admin", "admin");
		String selectQuery = "select * from customers where customer_id != '0'";	// except 'OBS'
		ArrayList<String> listCust = new ArrayList<String>();
		try {
			ResultSet resultSet = connector.executeSelect(conn, selectQuery);
			while (resultSet.next()) {
				String cust = resultSet.getString("customer_name");
				System.out.println(cust);
				listCust.add(cust);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TODO pass list of customers and count(equipment)
		request.setAttribute("listCustomer", listCust);
		
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