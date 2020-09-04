package acme.com.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import acme.com.domain.Editorial;
import acme.com.services.EditorialService;

@Controller
@RequestMapping("/editorial")
public class EditorialController {

	@Autowired
	private EditorialService editorialService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		
		ModelAndView maw = new ModelAndView("editorial/list");
		
		Collection<Editorial> editorials = editorialService.findAll();
		maw.addObject("editorialslist", editorials);
		
		return maw;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		
		ModelAndView maw = new ModelAndView("editorial/edit");
		
		Editorial editorial = editorialService.create();
		maw.addObject("editorial", editorial);
		
		return maw;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST , params = "delete")
	public ModelAndView deleteById(int id) {
		
		ModelAndView maw = new ModelAndView("editorial/list");
		try {
			editorialService.deleteById(id);
		}catch(Exception ex) {
			maw.addObject("Error","Error");
		}
	
		Collection<Editorial> editorials = editorialService.findAll();
		maw.addObject("editorialslist", editorials);
	
		return maw;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST , params = "save")
	public String save(@Valid Editorial ed, BindingResult bd) {
		
		if(bd.hasErrors()) {
			return "editorial/edit";
		}
		else {
			editorialService.save(ed);
			return "redirect:/editorial/list";				
		}
		
	}
}
