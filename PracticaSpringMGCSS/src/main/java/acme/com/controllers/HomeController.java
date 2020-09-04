package acme.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView findAll() {
	  
	  ModelAndView maw = new ModelAndView("home");
		  
	  return maw;
	  
  }
}
