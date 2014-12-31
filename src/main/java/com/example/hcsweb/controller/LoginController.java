package com.example.hcsweb.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.hcsweb.service.UserService;

@Controller 
public class LoginController {

	@Autowired
	private UserService userService;
	
	/**
	 * initialize session variables, record login information
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "login_success", method = RequestMethod.GET) // 
	public ModelAndView userInit(HttpServletRequest request){
 
		System.out.println("********[LoginController]********");
	
		// get current user from session
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		
		String username = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		System.out.println("username = " + username);

		if (username != null) {
			// init User object
			com.example.hcsweb.model.users.User user = userService.findUserByUsername(username);
			// update last login time
			user.setLastLoggedIn(new Timestamp(new Date().getTime()));
			userService.saveUser(user);
			
			// set session scope variables : current user
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", user);
			
			// set session scope variables : user type
			String userType = user.getUserType().getUserType();

			if (userType.equalsIgnoreCase("SuperAdmin"))
				session.setAttribute("isSuperAdmin", true);
			else
				session.setAttribute("isSuperAdmin", false);
			
			if (userType.equalsIgnoreCase("expertL3"))
				session.setAttribute("isExpertL3", true);
			else
				session.setAttribute("isExpertL3", false);
			
			if (userType.equalsIgnoreCase("expertL2"))
				session.setAttribute("isExpertL2", true);
			else
				session.setAttribute("isExpertL2", false);
			
			if (userType.equalsIgnoreCase("customerAdmin"))
				session.setAttribute("isCustAdmin", true);
			else
				session.setAttribute("isCustAdmin", false);
			
			if (userType.equalsIgnoreCase("hypervisor"))
				session.setAttribute("isHypervisor", true);
			else
				session.setAttribute("isHypervisor", false);
			
			if (userType.equalsIgnoreCase("supervisor"))
				session.setAttribute("isSupervisor", true);
			else
				session.setAttribute("isSupervisor", false);
						
		}
		// direct to index page
		ModelAndView model = new ModelAndView("redirect:/");
		return model;
 
	}

} 