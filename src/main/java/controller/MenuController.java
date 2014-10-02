package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

	@RequestMapping(value="customers", method = RequestMethod.GET)
	public ModelAndView listCustomers() {

		System.out.println("********MenuController being called********");
		
		ModelAndView model = new ModelAndView("customers");
		model.addObject("list", "controller: a list of customers");
		return model;
	}
}
