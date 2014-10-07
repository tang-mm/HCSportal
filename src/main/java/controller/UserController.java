package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.users.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping(value = "manageUsers", method = RequestMethod.GET)
	public ModelAndView showAllUser(HttpServletRequest request) {

		System.out.println("********[UserController] show all users********"); 
		
		
		// TEST: read from DB 
		ArrayList<User> listUser = new ArrayList<User>();
		listUser.add(new User("userTest1", "p1", 7));
		listUser.add(new User("userTest2", "p1", 7));
		listUser.add(new User("userTest3", "p1", 7));
		
		request.setAttribute("listUser", listUser);
		return new ModelAndView("UserAdmin/manageUsers");
	}
	
	
	@RequestMapping(value = "createNewUser", method = RequestMethod.GET)
	public ModelAndView createNewUser(HttpServletRequest request) {

		System.out.println("********[UserController] create new user********");
		String[] userTypes = {"SuperAdministrator", "Expert", "Customer Administrator", "Supervisor", "Agent"};
		request.setAttribute("userTypes", userTypes);
		return new ModelAndView("UserAdmin/newUser", "newUserCmd", new User());
	}

	
	@RequestMapping(value = "submitNewUser", method = RequestMethod.POST)
	public ModelAndView submitNewUser(@ModelAttribute User user) {
		return new ModelAndView("UserAdmin/success", "registerInfo", user);
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
