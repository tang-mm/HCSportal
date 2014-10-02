package controller;
     
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

	@RequestMapping(value = "register", method = RequestMethod.GET)
      public ModelAndView register(HttpServletRequest request) {
		
		System.out.println("********RegisterController being called********");
		
            String[] hobbies = {"Cricket", "Reading Books", "travel"};
            request.setAttribute("hobbies", hobbies);
           
            String[] states = {"Gujarat", "Maharastra", "Karnataka", "Kerala", "Tamil Nadu", "Hyderabad", "Madhya Pradesh", "Uttar Pradesh", "Rajasthan"};
            request.setAttribute("states", states);
            return new ModelAndView("registerView", "registerView", new RegisterViewBean());
     }
	 
	@RequestMapping(value = "submitRegistration", method = RequestMethod.POST)
     public ModelAndView submitRegistration(@ModelAttribute RegisterViewBean registerViewBean) {
           return new ModelAndView("success", "registerInfo", registerViewBean);
     }
}
