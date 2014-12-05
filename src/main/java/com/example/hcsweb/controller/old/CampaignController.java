package com.example.hcsweb.controller.old;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CampaignController {
	@RequestMapping(value="manageCampaigns", method=RequestMethod.GET)
	public ModelAndView listPinCode(HttpServletRequest request) {
		
		return new ModelAndView("Campaign/listCampaign");
	}
}