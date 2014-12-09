package com.example.hcsweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
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
	 * initiate session variables
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
			// set session variable
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", user);
			
			String userType = user.getUserType().getUserType();
			
			if (userType.equalsIgnoreCase("SuperAdmin"))
				session.setAttribute("isSuperAdmin", true);
			else if (userType.equalsIgnoreCase("expertL3"))
				session.setAttribute("isExpertL3", true);
			else if (userType.equalsIgnoreCase("expertL2"))
				session.setAttribute("isExpertL2", true);
			else if (userType.equalsIgnoreCase("customerAdmin"))
				session.setAttribute("isCustAdmin", true);
			else if (userType.equalsIgnoreCase("hypervisor"))
				session.setAttribute("isHypervisor", true);
			else if (userType.equalsIgnoreCase("supervisor"))
				session.setAttribute("isSupervisor", true);
			
		}
		// direct to index page
		ModelAndView model = new ModelAndView("redirect:/");
		return model;
 
	}

} 