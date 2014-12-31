package com.example.hcsweb.controller;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.hcsweb.model.users.User;
import com.example.hcsweb.model.users.UserType;
import com.example.hcsweb.service.UserService;
import com.example.hcsweb.service.UserTypeService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserTypeService userTypeService;
	
	@RequestMapping(value = "manageUsers", method = RequestMethod.GET)
	public ModelAndView showAllUser(HttpServletRequest request) {
	
		boolean isSuperAdmin = ((Boolean) request.getSession().getAttribute("isSuperAdmin")).booleanValue();
		boolean isExpertL3 = ((Boolean) request.getSession().getAttribute("isExpertL3")).booleanValue();
		boolean isExpertL2 = ((Boolean) request.getSession().getAttribute("isExpertL2")).booleanValue();
		
		System.out.println("-----user controler: isSuperAdmin = " + isSuperAdmin);
		System.out.println("********[UserController] show all users********");
		
		User user = (User) request.getSession().getAttribute("currentUser");
		//TODO check user permission on customers and show users
		List<User> listUser = userService.getAllUsers();
		
		request.setAttribute("listUser", listUser);
		return new ModelAndView("UserAdmin/manageUsers");
	}
	

	@RequestMapping(value = "createNewUser", method = RequestMethod.GET)
	public ModelAndView createNewUser(HttpServletRequest request, Principal principal) {
		// principal.getName();
		System.out.println("********[UserController] create new user********");

		User user = (User) request.getSession().getAttribute("currentUser");
		//TODO check creation permissions
		List<UserType> userTypes = userTypeService.getAllUserTypes();
		request.setAttribute("userTypes", userTypes);

		return new ModelAndView("UserAdmin/newUser", "newUserCmd", new User());
	}
	
	@RequestMapping(value = "submitNewUser", method = RequestMethod.POST)
	public ModelAndView submitNewUser(
			@Valid User user, HttpServletRequest request, BindingResult result, Model model) {
		// NewUserValidator validator = new NewUserValidator();
		// validator.validate(user, result);
		if (result.hasErrors()) {
			System.out.println(result.getFieldError().getField() + "\t" + result.getObjectName());
			List<UserType> userTypes = userTypeService.getAllUserTypes();
			request.setAttribute("userTypes", userTypes);
			return new ModelAndView("UserAdmin/newUser", "newUserCmd", user);
		}

		User currentUser = (User) request.getSession().getAttribute("currentUser");
		user.setCreatedBy(currentUser);
		user.setCreationTime(new Timestamp(new Date().getTime()));
		user.setLastLoggedIn(null);
		user.setEnabled(true);
		user.setCustomer(user.getCustomer());  //TODO if created by Expert, should choose from list
		userService.saveUser(user);
		request.setAttribute("message", "Successfully added new user!");
		return new ModelAndView("UserAdmin/newUser", "newUserCmd", user);
	}
	
	@RequestMapping(value = "userDetails", method = RequestMethod.GET)
	public ModelAndView userDetails (HttpServletRequest request) {
		//TODO
		return new ModelAndView("UserAdmin/userDetails");
	}
}
