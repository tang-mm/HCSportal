package controller;

import java.util.ArrayList;
import java.util.List;

import model.users.User;

import org.springframework.web.servlet.ModelAndView;

import com.exony.resourcemanagement.access.ResourceManagementAccess;
import com.exony.schemas._2009._10.resourcemanagement.ArrayOfNameValuePair;
import com.exony.schemas._2009._10.resourcemanagement.NameValuePair;
import com.exony.schemas._2009._10.resourcemanagement.ObjectFactory;
import com.exony.schemas._2009._10.resourcemanagement.RequestResult;
import com.exony.schemas._2009._10.resourcemanagement.Resource;

//@Controller
public class TestController {

	String server = "172.31.14.195";
	String webServiceURL = "https://" + server + ":8085/ResourceManagement";
	String username = "admin1";
	String password = "Gcc6koko$$";
	// String username="C1sup1";
	// String password="C1sco123";
	String customerName = "Customer1";

	
	// @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("index");
		return model;

	}

	public static void main(String[] args) {
		TestController test = new TestController();
		//		 test.retrieveAgent();
		test.createUserCCDM();
		test.retrieveUsers();
//		test.createPerson();
	}

	/**
	 * Create/Update Agent can only be done by Tenant Administrator 
	 */
	public void updateAgent() {

	}
	
	public void deleteAgent() {
		
	}
	
	
	
	public void createUserCCDM() {
		Resource newUser = new Resource();
		List<Resource> listResource = new ArrayList<Resource>();

		ObjectFactory objectFactory = new ObjectFactory(); 

		String folderId = "";
		try {
			ResourceManagementAccess accessObject = new ResourceManagementAccess(webServiceURL, username, password);

			// search for FolderId of the customer folder
			String searchQuery = "type:Tenant folder:/" + customerName;
			List<Resource> searchResult = accessObject.search(null, searchQuery);

			// !! ATTENTION ************* What if no sub-folder exists?********
			ArrayList<NameValuePair> listPair = (ArrayList<NameValuePair>) searchResult.get(0).getFields()
					.getNameValuePair(); // first sub-folder

			for (NameValuePair pair : listPair) {
				if (pair.getName().equalsIgnoreCase("FolderId")) {
					folderId = pair.getValue();
					System.out.println(pair.getName() + "\t" + pair.getValue());
				}
			}

			// set common attributes
//			 newUser.setIdentity(objectFactory.createResourceIdentity("111"));
			newUser.setType("User");
			newUser.setEffectiveFrom(objectFactory.createResourceEffectiveFrom("0001-01-01T00:00:00")); // default
																										// value
			newUser.setEffectiveTo(objectFactory.createResourceEffectiveTo("2079-06-06T00:00:00.0000000"));
			newUser.setStatus(objectFactory.createResourceStatus("R")); // "Ready"
			newUser.setChangestamp(0);

			// set Fields
			ArrayOfNameValuePair fields = new ArrayOfNameValuePair();
			User.addNameValuePairCCDMResource(fields, "FolderId", folderId);
			User.addNameValuePairCCDMResource(fields, "LoginName", "testUser2");
			User.addNameValuePairCCDMResource(fields, "PassPhrase", "Test1234");
			// User.addNameValuePair(fields, "Description", "test desc");
			// User.addNameValuePair(fields, "FirstName", "firstTest");
			// User.addNameValuePair(fields, "LastName", "lastTest");
			// User.addNameValuePair(fields, "Expert", "1");
			// User.addNameValuePair(fields, "TimeZone", "GMT Standard Time");
			newUser.setFields(fields);

			// update list
			listResource.add(newUser);

			/*
			 * Identity, Type, Fields: LoginName*, Expert, Description,
			 * FirstName, LastName, EMail, TimeZone
			 */

			// search type:folder latest:1 deleted:0
			// search type:Group enabled:1 folder:/<tenant>**

			List<RequestResult> createResult = accessObject.create(listResource);

			System.out.println("create user: " + createResult.get(0).getName().getValue());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public  void createPerson() {
		Resource newPerson = new Resource();
		List<Resource> listResource = new ArrayList<Resource>();

		ObjectFactory objectFactory = new ObjectFactory(); 

		try {
			ResourceManagementAccess accessObject = new ResourceManagementAccess(webServiceURL, username, password);
			String folderId = "6b88d0aa-c8de-4b9c-9538-64946c560cc0"; // "/Customer1"

			// set common attributes
			 newPerson.setIdentity(objectFactory.createResourceIdentity("-1"));
			newPerson.setType("Person");
			newPerson.setEffectiveFrom(objectFactory.createResourceEffectiveFrom("0001-01-01T00:00:00")); // default value
			newPerson.setEffectiveTo(objectFactory.createResourceEffectiveTo("2079-06-06T00:00:00.0000000"));
			newPerson.setStatus(objectFactory.createResourceStatus("R"));
			newPerson.setChangestamp(0);	// "Ready"

			// set Fields
			ArrayOfNameValuePair fields = new ArrayOfNameValuePair();
			User.addNameValuePairCCDMResource(fields, "FolderId", folderId);
			User.addNameValuePairCCDMResource(fields, "LoginName", "person_test");
			 User.addNameValuePairCCDMResource(fields, "Description", "test desc");
			 User.addNameValuePairCCDMResource(fields, "FirstName", "firstTest");
			 User.addNameValuePairCCDMResource(fields, "LastName", "lastTest");
//			 User.addNameValuePairCCDMResource(fields, "Expert", "1");
//			 User.addNameValuePairCCDMResource(fields, "TimeZone", "GMT Standard Time");
			newPerson.setFields(fields);

			// update list
			listResource.add(newPerson);

			// Identity, Type,
			// Fields: LoginName*, Expert, Description, FirstName, LastName,
			// EMail, TimeZone

			// search type:folder latest:1 deleted:0
			// search type:Group enabled:1 folder:/<tenant>**

			List<RequestResult> createResult = accessObject.create(listResource);

			System.out.println("create person: " + createResult.get(0).getErrors().getString().get(0));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void retrieveAgent() {
		ArrayList<String[]> listAgent = new ArrayList<String[]>();
		try {
			ResourceManagementAccess accessObject = new ResourceManagementAccess(
					webServiceURL, username, password);
			
			String searchQuery = "type:Agent";

			List<Resource> searchResult = accessObject.search(null, searchQuery);

			int idxLastName = -1;
			int idxFirstName = -1;
			int idxLoginName = -1;
			int idxOwnerName = -1;
			int idxIsSupervisor = -1;

			ArrayList<NameValuePair> listPair = (ArrayList<NameValuePair>) searchResult
					.get(0).getFields().getNameValuePair();
			for (NameValuePair pair : listPair) {
				if (pair.getName().equalsIgnoreCase("ParentPersonLastName"))
					idxLastName = listPair.indexOf(pair);
				if (pair.getName().equalsIgnoreCase("ParentPersonFirstName"))
					idxFirstName = listPair.indexOf(pair);
				if (pair.getName().equalsIgnoreCase("ParentPersonLoginName"))
					idxLoginName = listPair.indexOf(pair);
				if (pair.getName().equalsIgnoreCase("ParentOwnerName"))
					idxOwnerName = listPair.indexOf(pair);
				if (pair.getName().equalsIgnoreCase("Supervisor"))
					idxIsSupervisor = listPair.indexOf(pair);
			}

			for (Resource res : searchResult) {
				listPair = (ArrayList<NameValuePair>) res.getFields()
						.getNameValuePair();

				System.out.println(res.getIdentity().getValue() + "\t" +
						listPair.get(idxLoginName).getValue());
				
				listAgent.add(new String[] {
						listPair.get(idxLoginName).getValue(),
						listPair.get(idxLastName).getValue(),
						listPair.get(idxFirstName).getValue(),
						(listPair.get(idxIsSupervisor).getValue().equalsIgnoreCase("true")? "***" : ""), 
						listPair.get(idxOwnerName).getValue() }); 
			}
			

			for (String[] user : listAgent) {
				System.out.println(user[0] + "\t" + user[1] + "\t" + user[2] + "\t" + user[3]+ "\t" + user[4]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	public void retrieveTenant() {
		ResourceManagementAccess accessObject;
		try {
			
			accessObject = new ResourceManagementAccess(webServiceURL, username, password);

			System.out.println("********[UserController] retrieveTenant()");

			String searchQuery = "type:Tenant";

			List<Resource> searchResult = accessObject.search(null, searchQuery);

			int idxTenantName = -1;
			int idxParentOwnerName = -1;
			int idxCreationDate = -1;
			int idxModifiedDate = -1;

			// retrieve field names
			ArrayList<NameValuePair> listPair = (ArrayList<NameValuePair>) searchResult.get(0).getFields()
					.getNameValuePair();
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
				listPair = (ArrayList<NameValuePair>) res.getFields().getNameValuePair();

				listCustomer.add(new String[] { listPair.get(idxTenantName).getValue(),
						listPair.get(idxParentOwnerName).getValue(), listPair.get(idxCreationDate).getValue(),
						listPair.get(idxModifiedDate).getValue() });
			}

			for (String[] user : listCustomer) {
				System.out.println(user[0] + "\t" + user[1] + "\t" + user[2] + "\t" + user[3]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void retrieveUsers() {
		ArrayList<String[]> listUser = new ArrayList<String[]>();
		
		ResourceManagementAccess accessObject;
		try {
			accessObject = new ResourceManagementAccess(webServiceURL, username, password);
		String searchQuery = "type:User";
		List<Resource> searchResult = accessObject.search(null, searchQuery);
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
		for (Resource res : searchResult) {
			listPair = (ArrayList<NameValuePair>) res.getFields().getNameValuePair();
			listUser.add(new String[] { listPair.get(idxUserName).getValue(),
					listPair.get(idxDomainName).getValue(), listPair.get(idxCreatedBy).getValue(),
					listPair.get(idxCreationDate).getValue(), listPair.get(idxLastLogin).getValue() });
			
			System.out.println(listPair.get(idxUserName).getValue());
		}
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}