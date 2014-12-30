package com.example.hcsweb.controller;

import java.security.Principal;

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
import com.example.hcsweb.service.UserService;

@Controller
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	
	@RequestMapping(value = "manageUsers", method = RequestMethod.GET)
	public ModelAndView showAllUser(HttpServletRequest request) {
	
		boolean isSuperAdmin = Boolean.parseBoolean((String) request.getSession().getAttribute("isSuperAdmin"));
		System.out.println("-----user controler: isSuperAdmin = " + isSuperAdmin);
		System.out.println("********[UserController] show all users********");
		

		User user = (User) request.getSession().getAttribute("currentUser");
		
		
		return null;
	}
	

	@RequestMapping(value = "createNewUser", method = RequestMethod.GET)
	public ModelAndView createNewUser(HttpServletRequest request, Principal principal) {
		// principal.getName();
		System.out.println("********[UserController] create new user********");
		
		return null;
	}
	
	@RequestMapping(value = "submitNewUser", method = RequestMethod.POST)
	public ModelAndView submitNewUser(// @ModelAttribute("newUserCmd")
			@Valid User user, HttpServletRequest request, BindingResult result, Model model) {
	
	return null;
	}
}
