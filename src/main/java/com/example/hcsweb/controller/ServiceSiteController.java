package com.example.hcsweb.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.hcsweb.model.ExceptionalDay;
import com.example.hcsweb.model.Holiday;
import com.example.hcsweb.model.Service;
import com.example.hcsweb.model.Site;
import com.example.hcsweb.model.Tenant;
import com.example.hcsweb.model.users.User;
import com.example.hcsweb.service.ServiceService;
import com.example.hcsweb.service.SiteService;
import com.example.hcsweb.service.TenantService;

@Controller
public class ServiceSiteController {
	@Autowired
	private TenantService tenantService;
	@Autowired
	private ServiceService servService;
	@Autowired
	private SiteService siteService;
	
	
	@RequestMapping(value = "manageServices", method = RequestMethod.GET)
	public ModelAndView manageServices(HttpServletRequest request) {
		System.out.println("********[ServiceController] Manage Services ********");
	
		boolean isExpertL3 = ((Boolean)request.getSession().getAttribute("isExpertL3")).booleanValue();
		boolean isExpertL2 = ((Boolean)request.getSession().getAttribute("isExpertL2")).booleanValue();
		
		if (isExpertL3 || isExpertL2) {
			List<Tenant> listTenant = tenantService.getAllTenants();
			
			Service serv= servService.findServiceById(2);
			Site site = siteService.findSiteById(1);
			
			request.setAttribute("listTenant", listTenant);
			request.setAttribute("serv", serv); //TODO delete this 
			request.setAttribute("site", site);
			return new ModelAndView("Service/listServiceExpert");
		}

		// customer users
		User user = (User)request.getSession().getAttribute("currentUser");
		List<Service> listService = user.getListService();
		request.setAttribute("listService", listService);
		return new ModelAndView("Service/listServiceCust");
	
	}
	
	@RequestMapping(value = "listServices", method = RequestMethod.GET)
	public @ResponseBody List<Service> getServiceList(@RequestParam String tenantId) {
		System.out.println("********[ServiceController] get service list********");
		int tenantIdInt = Integer.parseInt(tenantId); 
		List<Service> listService = servService.findServicesByTenantId(tenantIdInt); 
		
		//TODO check open or not
		for (Service s : listService) {
			s.setOpen(true);
		}
		
//		listService.add(new Service(1, "Sale_001", 9, "testCustName", "location1", "UTC", false, true));
		return listService;
	}
	
	@RequestMapping(value = "serviceDetails", method = RequestMethod.GET)
	public ModelAndView showServiceDetails(HttpServletRequest request) {
		System.out.println("********[ServiceController] show service details********");
		int serviceId = Integer.parseInt(request.getParameter("id"));
		Service service = servService.findServiceById(serviceId);
		
		//TODO determine open or not
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK); 
 
		switch (day) {
		    case Calendar.SUNDAY:
		        // ...

		    case Calendar.MONDAY:
		        // etc ...
		}
		service.setOpen(true);
		
		List<Site> listSite = service.getListSite();
//		List<Site> listSite = siteService.findSitesByServiceId(serviceId);
		Site site = listSite.get(0);  //TODO should show all sites
		
		List<Holiday> listHoliday = site.getListHoliday();
		List<ExceptionalDay> listException = site.getListException();
		
		ModelAndView model = new ModelAndView("Service/serviceDetails");
		model.addObject("service", service); 
		model.addObject("site", site);
		model.addObject("listHoliday", listHoliday);
		model.addObject("listException", listException);
		
		//TODO language properties
		String[] weekdayNames = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		model.addObject("weekdayNames", weekdayNames);
		return model;
	}
}