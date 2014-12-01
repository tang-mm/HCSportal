package com.example.hcsweb.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.hcsweb.model.usersEnum.User;
import com.example.hcsweb.model.usersEnum.UserTypeEnum;
import com.example.hcsweb.validator.NewUserValidator;
import com.exony.resourcemanagement.access.ResourceManagementAccess;
import com.exony.schemas._2009._10.resourcemanagement.NameValuePair;
import com.exony.schemas._2009._10.resourcemanagement.Resource;
import com.mysql.jdbc.Connection;

@Controller
public class UserController {
	@RequestMapping(value = "manageUsers", method = RequestMethod.GET)
	public ModelAndView showAllUser(HttpServletRequest request) {
		boolean isSuperAdmin = Boolean.parseBoolean((String) request.getSession().getAttribute("isSuperAdmin"));
		System.out.println("-----user controler: isSuperAdmin = " + isSuperAdmin);
		System.out.println("********[UserController] show all users********");
		ArrayList<String[]> listUser = new ArrayList<String[]>();
		try {
			CcdmManager ccdm = new CcdmManager();
			List<Resource> searchResult = ccdm.retrieveUsers(""); // from folder
																	// "/Root"
			// find index of fields to display
			int idxUserName = -1;
			int idxDomainName = -1;
			int idxLastLogin = -1;
			int idxCreatedBy = -1;
			int idxCreationDate = -1;
			ArrayList<NameValuePair> listPair = (ArrayList<NameValuePair>) searchResult.get(0).getFields()
					.getNameValuePair();
			for (NameValuePair pair : listPair) {
				if (pair.getName().equalsIgnoreCase("UserName"))
					idxUserName = listPair.indexOf(pair);
				if (pair.getName().equalsIgnoreCase("DomainName"))
					idxDomainName = listPair.indexOf(pair);
				if (pair.getName().equalsIgnoreCase("ParentCreatedByLoginName"))
					idxCreatedBy = listPair.indexOf(pair);
				if (pair.getName().equalsIgnoreCase("CreationDate"))
					idxCreationDate = listPair.indexOf(pair);
				if (pair.getName().equalsIgnoreCase("LastLogin"))
					idxLastLogin = listPair.indexOf(pair);
			}
			// construct list to pass as attribute
			for (Resource res : searchResult) {
				listPair = (ArrayList<NameValuePair>) res.getFields().getNameValuePair();
				listUser.add(new String[] { listPair.get(idxUserName).getValue(),
						listPair.get(idxDomainName).getValue(), listPair.get(idxCreatedBy).getValue(),
						listPair.get(idxCreationDate).getValue(), listPair.get(idxLastLogin).getValue() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("listUser", listUser);
		return new ModelAndView("UserAdmin/manageUsers");
	}

	@RequestMapping(value = "createNewUser", method = RequestMethod.GET)
	public ModelAndView createNewUser(HttpServletRequest request, Principal principal) {
		// principal.getName();
		System.out.println("********[UserController] create new user********");
		request.setAttribute("userTypes", UserTypeEnum.values());
		// TODO change user types list following current user profile
		// request.isUserInRole("ROLE_SUPERADMIN");
		// request.isUserInRole("ROLE_EXPERT");
		// request.isUserInRole("ROLE_ADMIN");
		// request.isUserInRole("ROLE_SUPERVISOR");
		return new ModelAndView("UserAdmin/newUser", "newUserCmd", new User());
	}

	@RequestMapping(value = "submitNewUser", method = RequestMethod.POST)
	public ModelAndView submitNewUser(// @ModelAttribute("newUserCmd")
			@Valid User user, HttpServletRequest request, BindingResult result, Model model) {
		// NewUserValidator validator = new NewUserValidator();
		// validator.validate(user, result);
		if (result.hasErrors()) {
			System.out.println(result.getFieldError().getField() + "\t" + result.getObjectName());
			model.addAttribute("userTypes", UserTypeEnum.values());
			return new ModelAndView("UserAdmin/newUser", "newUserCmd", user);
		}
		// JDBCConnector connector = new JDBCConnector();
		// Connection conn = connector.getDBConnection(username, password); //
		// TODO current username + password
		//
		//
		// connector.insertIntoUsersTable(conn, user.getUsername(),
		// user.getPassword(), user.getUserTypeId(), customerId, currentUserId,
		// timestamp, timezone, enabled);
		model.addAttribute("message", "success " + user.getUsername());
		return new ModelAndView("UserAdmin/test_success", "newUserCmd", user);
	}
}