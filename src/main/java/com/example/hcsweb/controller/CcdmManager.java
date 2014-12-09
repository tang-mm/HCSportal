package com.example.hcsweb.controller;

import java.util.ArrayList;
import java.util.List;
 
import com.exony.resourcemanagement.access.ResourceManagementAccess;
import com.exony.schemas._2009._10.resourcemanagement.ArrayOfNameValuePair;
import com.exony.schemas._2009._10.resourcemanagement.NameValuePair;
import com.exony.schemas._2009._10.resourcemanagement.ObjectFactory;
import com.exony.schemas._2009._10.resourcemanagement.RequestResult;
import com.exony.schemas._2009._10.resourcemanagement.Resource;

public class CcdmManager {

	private String serverIP = "172.31.14.195";
	private String username = "admin1";
	private String password = "Gcc6koko$$";		// base64password
	// String username="C1sup1";
	// String password="C1sco123";
	private String tenantName = "Customer1";
	private ResourceManagementAccess accessObject;

	private String webServiceURL = "https://" + serverIP + ":8085/ResourceManagement";

	public CcdmManager() throws Exception {
		accessObject = new ResourceManagementAccess(webServiceURL, username, password);
	}

	public CcdmManager(String serverIP, String username, String password, String tenantName) throws Exception {
		this.serverIP = serverIP;
		this.username = username;
		this.password = password;
		this.tenantName = tenantName;
		accessObject = new ResourceManagementAccess(webServiceURL, username, password);
	}

	public List<Resource> retrieveUsers(String folder) throws Exception { 
		String searchQuery = "type:User latest:1 deleted:0 folder:/" + folder;
		List<Resource> searchResult = accessObject.search(null, searchQuery);

		return searchResult;
	}

	public List<Resource> retrieveAgents(String folder) throws Exception {

		String searchQuery = "type:Agent latest:1 deleted:0 folder:/" + folder;
		List<Resource> searchResult = accessObject.search(null, searchQuery);

		return searchResult;
	}

	public List<Resource> retrieveTenants() throws Exception { 
		String searchQuery = "type:Tenant latest:1 deleted:0";
		List<Resource> searchResult = accessObject.search(null, searchQuery);

		return searchResult;
	}

	public void createUserCCDM(String loginName, String passPhrase) {
		Resource newUser = new Resource();
		List<Resource> listResource = new ArrayList<Resource>();

		ObjectFactory objectFactory = new ObjectFactory();

		String folderId = "";
		try {
			ResourceManagementAccess accessObject = new ResourceManagementAccess(webServiceURL, username, password);

			// search for FolderId of the customer folder
			String searchQuery = "type:Tenant folder:/" + tenantName;
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
			// newUser.setIdentity(objectFactory.createResourceIdentity("111"));
			newUser.setType("User");
			newUser.setEffectiveFrom(objectFactory.createResourceEffectiveFrom("0001-01-01T00:00:00")); // default
																										// value
			newUser.setEffectiveTo(objectFactory.createResourceEffectiveTo("2079-06-06T00:00:00.0000000"));
			newUser.setStatus(objectFactory.createResourceStatus("R")); // "Ready"
			newUser.setChangestamp(0);

			// set Fields
			ArrayOfNameValuePair fields = new ArrayOfNameValuePair();
//			User.addNameValuePairCCDMResource(fields, "FolderId", folderId);
//			User.addNameValuePairCCDMResource(fields, "LoginName", loginName);
//			User.addNameValuePairCCDMResource(fields, "PassPhrase", passPhrase);
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

	public String getServerIP() {
		return serverIP;
	}

	/**
	 * set server IP address and generate WebServiceURL
	 * @param serverIP
	 */
	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
		this.setWebServiceURL("https://" + serverIP + ":8085/ResourceManagement");
	}

	public String getWebServiceURL() {
		return webServiceURL;
	}

	private void setWebServiceURL(String webServiceURL) {
		this.webServiceURL = webServiceURL;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomerName() {
		return tenantName;
	}

	public void setCustomerName(String customerName) {
		this.tenantName = customerName;
	}

}
