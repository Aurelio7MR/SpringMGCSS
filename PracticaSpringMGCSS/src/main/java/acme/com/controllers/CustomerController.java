package acme.com.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import acme.com.domain.Customer;
import acme.com.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView findAll() {
		
		ModelAndView maw = new ModelAndView("customer/list");
		
		Collection<Customer> customer = customerService.findAll();
		maw.addObject("customerslist", customer);
		
		return maw;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		
		ModelAndView maw = new ModelAndView("customer/edit");
		
		Customer customer = customerService.create();
		maw.addObject("customer", customer);
		
		return maw;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, params = "delete")
	public ModelAndView deleteById(int id) {
		
		ModelAndView maw = new ModelAndView("customer/list");
		
		try {
			customerService.deleteById(id);
		} catch (Exception e) {
			maw.addObject("Error", "Error") ;
		}
		Collection<Customer> customer = customerService.findAll();
		maw.addObject("customerslist", customer);
		return maw;
		
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST , params = "save")
	public String save(@Valid Customer c, BindingResult bd) {
		
		if(bd.hasErrors()) {
			return "customer/edit";
		}
		else {
			customerService.save(c);
			return "redirect:/customer/list";				
		}
		
	}
}
