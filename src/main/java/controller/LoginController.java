package controller;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  

@Controller
//@RequestMapping("/login")
public class LoginController {
 

	@Autowired
	private LoginValidator loginValidator;

	/**
	 * load the login.jsp page when the application starts
	 * 
	 * @return
	 */
//	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(Model  model){
		model.addAttribute("user", new User());
		return "login";
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