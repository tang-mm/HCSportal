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
//			String username="administrator";
			String username="C1sup1";
			String password="C1sco123";
			
			accessObject = new ResourceManagementAccess(webServiceURL, username, password);
			System.out.println("retrieveAgent()");
			
			String searchQuery = "type:Agent";
					
			List<Resource> searchResult = accessObject.search(null, searchQuery);
			
			for (Resource res : searchResult) {
				ArrayList<NameValuePair> listPair = (ArrayList<NameValuePair>) res.getFields().getNameValuePair();
 
				for (NameValuePair pair : listPair) {  
					System.out.print(pair.getValue() + ", ");
				}
				System.out.println("");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	} 
 
}