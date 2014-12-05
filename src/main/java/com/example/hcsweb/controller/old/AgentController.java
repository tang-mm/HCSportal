package com.example.hcsweb.controller.old;

import java.util.ArrayList;
import java.util.List;
 


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.hcsweb.model.usersEnum.Supervisor;
import com.exony.resourcemanagement.access.ResourceManagementAccess;
import com.exony.schemas._2009._10.resourcemanagement.NameValuePair;
import com.exony.schemas._2009._10.resourcemanagement.Resource;

@Controller
public class AgentController {


	@RequestMapping(value="manageAgents", method = RequestMethod.GET)
	public ModelAndView listAgents() {

		System.out.println("********[AgentController] manage agents********");

		ArrayList<String[]> listAgent = new ArrayList<String[]>();
		try {

			CcdmManager ccdm = new CcdmManager();
			List<Resource> searchResult = ccdm.retrieveAgents("Customer1");	// from folder "/Customer1"

			// find index of fields to display
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

			// construct list to pass as attribute
			for (Resource res : searchResult) {
				listPair = (ArrayList<NameValuePair>) res.getFields()
						.getNameValuePair();

				listAgent.add(new String[] {
						listPair.get(idxLoginName).getValue(),
						listPair.get(idxLastName).getValue(),
						listPair.get(idxFirstName).getValue(),
						(listPair.get(idxIsSupervisor).getValue().equalsIgnoreCase("true")? "***" : ""), 
						listPair.get(idxOwnerName).getValue() }); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		ModelAndView model = new ModelAndView("UserAdmin/manageAgents");
		model.addObject("listAgent", listAgent);
		return model;
	}

	@RequestMapping(value="createNewAgent", method = RequestMethod.GET)
	public ModelAndView createAgent() {

		System.out.println("********[AgentController] create new customer********");
		
		ModelAndView model = new ModelAndView("UserAdmin/newAgent", "newAgentCmd", new Supervisor());
		model.addObject("IPaddress ", "controller: new agent");
		return model;
	}
}
