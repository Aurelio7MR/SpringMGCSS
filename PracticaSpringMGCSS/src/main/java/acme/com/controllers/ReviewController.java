package acme.com.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import acme.com.domain.Review;
import acme.com.services.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		
		ModelAndView maw = new ModelAndView("review/list");
		
		Collection<Review> reviews = reviewService.findAll();
		maw.addObject("reviewslist", reviews);
		
		return maw;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		
		ModelAndView maw = new ModelAndView("review/edit");
		
		Review review = reviewService.create();
		maw.addObject("review", review);
		
		return maw;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST , params = "delete")
	public ModelAndView deleteById(int id) {
		
		ModelAndView maw = new ModelAndView("review/list");
		try {

			reviewService.deleteById(id);
		
		}catch(Exception ex) {
			maw.addObject("Error","Error");
		}
	
		Collection<Review> reviews = reviewService.findAll();
		maw.addObject("reviewslist", reviews);
	
		return maw;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST , params = "save")
	public String save(@Valid Review r, BindingResult bd) {
		
		if(bd.hasErrors()) {
			return "review/edit";
		}
		else {
			reviewService.save(r);
			return "redirect:/review/list";				
		}
		
	}
}
