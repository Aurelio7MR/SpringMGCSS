
package acme.com.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import acme.com.domain.Book;
import acme.com.repositories.BookRepository;

@Service
@Transactional
public class BookService {

	// Managed repository -------------------------------

	@Autowired
	private BookRepository bookRepository;

	// Supporting services ------------------------------


	// Constructors -------------------------------------

	public BookService() {
		super();
	}

	// Simple CRUD methods

	public Book create() {
		Book result;

		result = new Book();

		return result;
	}

	public void save(Book book) {
		bookRepository.save(book);
	}

	public Collection<Book> findAll() {
		Collection<Book> books;

		books = bookRepository.findAll();

		return books;
	}

}
