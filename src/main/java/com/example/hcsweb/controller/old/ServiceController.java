package com.example.hcsweb.controller.old;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.hcsweb.model.ExceptionalDay;
import com.example.hcsweb.model.Service;
import com.example.hcsweb.model.Tenant;

//@Controller
public class ServiceController {
	@RequestMapping(value = "manageServices", method = RequestMethod.GET)
	public ModelAndView manageServices(HttpServletRequest request) {
		System.out.println("********[ServiceController] Manage Services ********");
		boolean isExpert = Boolean.parseBoolean((String) request.getSession().getAttribute(
				"isExpert"));
		isExpert = true; // TODO delete this line!!!
		if (isExpert) {
			ArrayList<Tenant> listCustomer = new ArrayList<Tenant>();
			// TODO get customer list
			listCustomer.add(new Tenant("testName", "testIP", "test"));
			request.setAttribute("listCustomer", listCustomer);
			return new ModelAndView("Service/listServiceExpert");
		}
		// TODO get customer ID
		String customerName = null;
		int customerId = 0;
		request.setAttribute("customerId", customerId);
		request.setAttribute("customerName", customerName);
		// TODO retrieve list from DB
		ArrayList<Service> listService = new ArrayList<Service>();
		request.setAttribute("listService", listService);
		return new ModelAndView("Service/listServiceCust");
	}

	@RequestMapping(value = "listServices", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Service> getServiceList(@RequestParam String custId) {
		System.out.println("********[ServiceController] get service list********");
		ArrayList<Service> listService = new ArrayList<Service>();
		// TODO retrieve list from DB
//		listService.add(new Service(1, "Sale_001", 9, "testCustName", "location1", "UTC", false, true));
		return listService;
	}

	@RequestMapping(value = "serviceDetails", method = RequestMethod.GET)
	public ModelAndView showServiceDetails(HttpServletRequest request) {
		System.out.println("********[ServiceController] show service details********");
		String serviceId = request.getParameter("id");
		
		Service service = null;
		ExceptionalDay[] weekdayHours = new ExceptionalDay[7]; //key: weekday Number 
		ArrayList<ExceptionalDay> listHoliday = new ArrayList<ExceptionalDay>();
		ArrayList<ExceptionalDay> listException = new ArrayList<ExceptionalDay>();
		
		
		String queryServ = " SELECT * FROM services s, locations l WHERE s.service_id = " + serviceId + " AND s.location_id = l.location_id";		
		String queryWeek = "SELECT * FROM weekdays WHERE service_id = " + serviceId;
		String queryHoliday = "SELECT * FROM holidays WHERE service_id = " + serviceId;
		String queryExcept = "SELECT * FROM exceptional_days WHERE service_id = " + serviceId;
	
		//TODO Connection pooling
		JdbcConnector connector = new JdbcConnector();
		Connection conn = connector.getDBConnection("admin", "admin");
		try {
			// get Service object fields
			ResultSet resultSet = connector.executeSelect(conn, queryServ);
			if (resultSet.first()) {
				String serviceCode = resultSet.getString("s.service_code");
				int tenantId = resultSet.getInt("s.customer_id");
				String state = resultSet.getString("l.state");
				String location = resultSet.getString("l.city") + ", " + (state == null? "" : state + ", ") + resultSet.getString("l.country");
				String timeZone = resultSet.getString("l.time_zone");
				boolean emergency = resultSet.getBoolean("emergency_state");
				
				service = new Service();
//				service.setLocation(location);
//				service.setTimeZone(timeZone);
				service.setServiceCode(serviceCode);
//				service.setTenantId(tenantId); 
				service.setEmergency(emergency);
				//TODO boolean: open
				
				System.out.println(serviceId + "\t" + serviceCode + "\t" + location);
			}
			
			// get Weekday working hours
			resultSet = connector.executeSelect(conn, queryWeek);
			while (resultSet.next()) {
				int weekday = resultSet.getInt("weekday");
				Time open1 = resultSet.getTime("open_time_1");
				Time close1 = resultSet.getTime("close_time_1");
				Time open2 = resultSet.getTime("open_time_2");
				Time close2 = resultSet.getTime("close_time_2"); 
				weekdayHours[weekday-1] = new ExceptionalDay(open1, close1, open2, close2);
			}
			for (int i = 0; i < 7; i++) { // in case no working hours registered
				if (weekdayHours[i] == null) {
					weekdayHours[i] = new ExceptionalDay();
				}
			}
			
			// get holidays
			resultSet = connector.executeSelect(conn, queryHoliday);
			while (resultSet.next()) { 
				ExceptionalDay day = new ExceptionalDay();
				day.setDate(resultSet.getDate("holiday"));
				day.setDescription(resultSet.getString("description"));
				listHoliday.add(day);
			}
			
			// get exceptional days
			resultSet = connector.executeSelect(conn, queryExcept);
			while (resultSet.next()) {
				Time open1 = resultSet.getTime("open_time_1");
				Time close1 = resultSet.getTime("close_time_1");
				Time open2 = resultSet.getTime("open_time_2");
				Time close2 = resultSet.getTime("close_time_2");
				ExceptionalDay day = new ExceptionalDay(open1, close1, open2, close2);
				
				day.setDate(resultSet.getDate("exception_date"));
				day.setDescription(resultSet.getString("description"));
				
				listException.add(day);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView model = new ModelAndView("Service/serviceDetails");
		model.addObject("service", service); 
		model.addObject("weekdayHours", weekdayHours);
		model.addObject("listHoliday", listHoliday);
		model.addObject("listException", listException);
		
		//TODO language properties
		String[] weekdayNames = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		model.addObject("weekdayNames", weekdayNames);
		return model;
	}

	@RequestMapping(value = "createNewService", method = RequestMethod.GET)
	public ModelAndView createNewService() {
		System.out.println("********[ServiceController] create new service********");
		ModelAndView model = new ModelAndView("Service/newService", "newServiceCmd", new Service());
		return model;
	}

	@RequestMapping(value = "submitNewService", method = RequestMethod.POST)
	public ModelAndView submitNewService(@ModelAttribute Service service) {
		ModelAndView model = new ModelAndView("Service/newService", "newServiceCmd", service);
		// TODO add into database
		model.addObject("message", "Successfully added new service!");
		return model;
	}
}