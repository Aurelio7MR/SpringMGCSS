package acme.com.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import acme.com.domain.Book;
import acme.com.services.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView findAll() {
		
		ModelAndView maw = new ModelAndView("book/list");
		
		Collection<Book> libros = bookService.findAll();
		maw.addObject("bookslist", libros);
		
		return maw;
	}
}
