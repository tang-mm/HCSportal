package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class LoginController {

	@Autowired
//	private LoginValidator loginValidator;
	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	@RequestMapping(value = "login", method = RequestMethod.GET) // 
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

		LOG.info("********LoginController being called********");
		System.out.println("********LoginController being called********");
		
		ModelAndView model = new ModelAndView();
//		if (error != null) {
//			model.addObject("error", "Invalid username and password!");
//		}
// 
//		if (logout != null) {
//			model.addObject("logoutMsg", "You've been logged out successfully.");
//		}
//		model.setViewName("index");
 
		return model;
 
	}
	
//	public ModelAndView launchLoginForm() {  
//		ModelAndView model = new ModelAndView("login", "user", new User());
//		return model;
//	}

	
//	@RequestMapping(method = RequestMethod.POST)
//	public ModelAndView submitForm(User user, BindingResult result) {//
//		String name = user.getUsername();
//		// String prestatement = "Hello";
//
//		loginValidator.validate(name, result);
//		model.addAttribute("user", user);
//		
//		if (result.hasErrors())
//			return "login";
//
//		return "redirect:success";
//		 
//	}

//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public String validateSubmit(
//			@Valid @ModelAttribute("loginCommand") User user,
//			BindingResult result) { //
//
//		return null;
//	}
} 