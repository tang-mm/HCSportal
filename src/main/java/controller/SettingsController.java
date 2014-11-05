package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingsController {
	
	@RequestMapping(value="settings", method=RequestMethod.GET)
	public ModelAndView showSettings(HttpServletRequest request) {
		
		return new ModelAndView("Settings/settings");
	}
}
