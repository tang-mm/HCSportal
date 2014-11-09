package controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.Customer;
import model.Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceController {
	@RequestMapping(value = "manageServices", method = RequestMethod.GET)
	public ModelAndView manageServices(HttpServletRequest request) {
		System.out.println("********[ServiceController] Manage Services ********");
		boolean isExpert = Boolean.parseBoolean((String) request.getSession().getAttribute(
				"isExpert"));
		isExpert = true; // TODO delete this line!!!
		if (isExpert) {
			ArrayList<Customer> listCustomer = new ArrayList<Customer>();
			// TODO get customer list
			listCustomer.add(new Customer(9, "testName", "testIP", "test", 24));
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
		listService.add(new Service(1, "testCode", 9, "testCustName", "location1", "UTC", false,
				true));
		return listService;
	}

	@RequestMapping(value = "serviceDetails", method = RequestMethod.GET)
	public ModelAndView showServiceDetails(HttpServletRequest request) {
		System.out.println("********[ServiceController] show service details********");
		String serviceId = request.getParameter("serviceId");
		// TODO retrieve row from DB
		Service service = new Service();
		request.setAttribute("service", service);
		return new ModelAndView("Service/serviceDetails");
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