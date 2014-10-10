package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.users.inEnum.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exony.resourcemanagement.access.ResourceManagementAccess;
import com.exony.schemas._2009._10.resourcemanagement.NameValuePair;
import com.exony.schemas._2009._10.resourcemanagement.Resource;

@Controller
public class UserController {

	@RequestMapping(value = "manageUsers", method = RequestMethod.GET)
	public ModelAndView showAllUser(HttpServletRequest request) {

		System.out.println("********[UserController] show all users********"); 
		

		String server = "172.31.14.195";
		String webServiceURL = "https://" + server + ":8085/ResourceManagement";
		String username="administrator";
		String password = "C1sco123";
		ArrayList<String[]> listUser = new ArrayList<String[]>();
		try {
			ResourceManagementAccess accessObject = new ResourceManagementAccess(
					webServiceURL, username, password); 
			String searchQuery = "type:User"; 
			List<Resource> searchResult = accessObject
					.search(null, searchQuery);

			int idxUserName = -1;
			int idxDomainName = -1;
			int idxLastLogin = -1;
			int idxCreatedBy = -1;
			int idxCreationDate = -1;

			ArrayList<NameValuePair> listPair = (ArrayList<NameValuePair>) searchResult
					.get(0).getFields().getNameValuePair();
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

			for (Resource res : searchResult) {
				listPair = (ArrayList<NameValuePair>) res.getFields()
						.getNameValuePair();

				listUser.add(new String[] {
						listPair.get(idxUserName).getValue(),
						listPair.get(idxDomainName).getValue(),
						listPair.get(idxCreatedBy).getValue(),
						listPair.get(idxCreationDate).getValue(),
						listPair.get(idxLastLogin).getValue() }); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		request.setAttribute("listUser", listUser);
		return new ModelAndView("UserAdmin/manageUsers");
	}
	
	
	@RequestMapping(value = "createNewUser", method = RequestMethod.GET)
	public ModelAndView createNewUser(HttpServletRequest request) {

		System.out.println("********[UserController] create new user********");
		ArrayList<String[]> userTypes = new ArrayList<String[]>();
		userTypes.add(new String[]{"SuperAdministrator", "1"});
		userTypes.add(new String[]{"Expert L3", "2"});
		userTypes.add(new String[]{"Expert L2", "3"});
		userTypes.add(new String[]{"Expert L1", "4"});
		userTypes.add(new String[]{"Tenant Administrator", "5"});
		userTypes.add(new String[]{"Supervisor", "6"});
		userTypes.add(new String[]{"Agent", "7"});
		request.setAttribute("userTypes", userTypes);
		return new ModelAndView("UserAdmin/newUser", "newUserCmd", new User());
	}

	
	@RequestMapping(value = "submitNewUser", method = RequestMethod.POST)
	public ModelAndView submitNewUser(@ModelAttribute User user) {
		return new ModelAndView("UserAdmin/success", "registerInfo", user);
	} 

}
