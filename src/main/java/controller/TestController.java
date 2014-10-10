package controller;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.exony.resourcemanagement.access.ResourceManagementAccess;
import com.exony.schemas._2009._10.resourcemanagement.NameValuePair;
import com.exony.schemas._2009._10.resourcemanagement.Resource;
 
//@Controller
public class TestController {
 
//	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("index");
		return model;
 
	}
	
	public static void main(String[] args) {
		retrieveAgent();
	}
 
	public static void retrieveAgent() {
		ResourceManagementAccess accessObject;
		try {
			String server="172.31.14.195";
			String webServiceURL = "https://" + server + ":8085/ResourceManagement";
			String username="administrator";
//			String username="C1sup1";
			String password="C1sco123";
			 
			accessObject = new ResourceManagementAccess(
					webServiceURL, username, password);

			System.out.println("********[UserController] retrieveAgent()");

			String searchQuery = "type:Tenant";

			List<Resource> searchResult = accessObject
					.search(null, searchQuery);

			int idxTenantName = -1;
			int idxParentOwnerName = -1; 
			int idxCreationDate = -1;
			int idxModifiedDate = -1;
			
			// retrieve field names
			ArrayList<NameValuePair> listPair = (ArrayList<NameValuePair>) searchResult
					.get(0).getFields().getNameValuePair();
			for (NameValuePair pair : listPair) {
				if (pair.getName().equalsIgnoreCase("Name"))
					idxTenantName = listPair.indexOf(pair);
				if (pair.getName().equalsIgnoreCase("ParentOwnerName"))
					idxParentOwnerName = listPair.indexOf(pair);
				if (pair.getName().equalsIgnoreCase("CreationDate"))
					idxCreationDate = listPair.indexOf(pair);
				if (pair.getName().equalsIgnoreCase("ModifiedDate"))
					idxModifiedDate = listPair.indexOf(pair);
			}

			ArrayList<String[]> listCustomer = new ArrayList<String[]>();
			// retrieve field values
			for (Resource res : searchResult) {
				listPair = (ArrayList<NameValuePair>) res.getFields()
						.getNameValuePair();

				listCustomer.add(new String[] { 
						listPair.get(idxTenantName).getValue(),
						listPair.get(idxParentOwnerName).getValue(),
						listPair.get(idxCreationDate).getValue(),
						listPair.get(idxModifiedDate).getValue()
				});
			}
			
			for (String[] user : listCustomer) {
				System.out.println(user[0] + "\t" + user[1] + "\t" + user[2]+ "\t" + user[3]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	} 
 
}