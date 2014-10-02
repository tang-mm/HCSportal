package controller;

import javax.servlet.http.HttpServletRequest;

import model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping(value = "users", method = RequestMethod.GET)
	public String showAllUser(HttpServletRequest request) {

		System.out.println("********UserController being called: show all users********"); 
		return "users";
	}
	
	@RequestMapping(value = "createNewUser", method = RequestMethod.GET)
	public ModelAndView createNewUser(HttpServletRequest request) {

		System.out.println("********UserController being called: create new user********");
		String[] userTypes = {"SuperAdministrator", "Expert", "Customer Administrator", "Supervisor", "Agent"};
		request.setAttribute("userTypes", userTypes);
		return new ModelAndView("newUser", "registerView", new User());
	}

	@RequestMapping(value = "submitNewUser", method = RequestMethod.POST)
	public ModelAndView submitNewUser(@ModelAttribute User user) {
		return new ModelAndView("success", "registerInfo", user);
	}
//	
//	@RequestMapping(value = "register", method = RequestMethod.GET)
//      public ModelAndView register(HttpServletRequest request) {
//		
//		System.out.println("********RegisterController being called********");
//		
//            String[] hobbies = {"Cricket", "Reading Books", "travel"};
//            request.setAttribute("hobbies", hobbies);
//           
//            String[] states = {"Gujarat", "Maharastra", "Karnataka", "Kerala", "Tamil Nadu", "Hyderabad", "Madhya Pradesh", "Uttar Pradesh", "Rajasthan"};
//            request.setAttribute("states", states);
//            return new ModelAndView("registerView", "registerView", new RegisterViewBean());
//     }
//	 
//	@RequestMapping(value = "submitRegistration", method = RequestMethod.POST)
//     public ModelAndView submitRegistration(@ModelAttribute RegisterViewBean registerViewBean) {
//           return new ModelAndView("success", "registerInfo", registerViewBean);
//     }

}
