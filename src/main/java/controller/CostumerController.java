package controller;

import java.util.ArrayList;
import java.util.List;

import model.Customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exony.resourcemanagement.access.ResourceManagementAccess;
import com.exony.schemas._2009._10.resourcemanagement.NameValuePair;
import com.exony.schemas._2009._10.resourcemanagement.Resource;

@Controller
public class CostumerController {

	@RequestMapping(value="manageCustomers", method = RequestMethod.GET)
	public ModelAndView listCustomers() {

		System.out.println("********[CostumerController] manage customers********");
 
		ArrayList<String[]> listCustomer = new ArrayList<String[]>();
		
		try {
			CcdmManager ccdm = new CcdmManager();
			List<Resource> searchResult = ccdm.retrieveTenants();

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
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
		ModelAndView model = new ModelAndView("UserAdmin/manageCustomers");
		model.addObject("listCustomer", listCustomer);
		return model;
	}

	@RequestMapping(value="createNewCustomer", method = RequestMethod.GET)
	public ModelAndView createCustomer() {

		System.out.println("********[CostumerController] create new customer********");
		
		ModelAndView model = new ModelAndView("UserAdmin/newCustomer", "newCustomerCmd", new Customer());
//		model.addObject("IPaddress", "controller: new customer");
		return model;
	}

}
