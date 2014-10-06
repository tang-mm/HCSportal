package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CostumerController {

	@RequestMapping(value="manageCustomers", method = RequestMethod.GET)
	public ModelAndView listCustomers() {

		System.out.println("********[CostumerController] manage customers********");
		
		ModelAndView model = new ModelAndView("UserAdmin/manageCustomers");
		model.addObject("listCostumer", "controller: a list of customers");
		return model;
	}

	@RequestMapping(value="createNewCustomer", method = RequestMethod.GET)
	public ModelAndView createCustomer() {

		System.out.println("********[CostumerController] create new customer********");
		
		ModelAndView model = new ModelAndView("UserAdmin/newCustomer");
		model.addObject("IPadd ", "controller: new customer");
		return model;
	}
}
