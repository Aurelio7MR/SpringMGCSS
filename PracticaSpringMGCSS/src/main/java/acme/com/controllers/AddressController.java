package acme.com.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import acme.com.domain.Address;
import acme.com.services.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView findAll() {
		
		ModelAndView maw = new ModelAndView("address/list");
		
		Collection<Address> address = addressService.findAll();
		maw.addObject("addresseslist", address);
		
		return maw;
	}
}
