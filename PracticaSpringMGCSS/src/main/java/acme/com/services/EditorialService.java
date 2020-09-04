
package acme.com.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import acme.com.domain.Editorial;
import acme.com.repositories.EditorialRepository;

@Service
@Transactional
public class EditorialService {

	// Managed repository -------------------------------

	@Autowired
	private EditorialRepository editorialRepository;

	// Supporting services ------------------------------


	// Constructors -------------------------------------

	public EditorialService() {
		super();
	}

	// Simple CRUD methods

	public Editorial create() {
		Editorial result;

		result = new Editorial();

		return result;
	}

	public void save(Editorial editorial) {
		editorialRepository.save(editorial);
	}

	public Collection<Editorial> findAll() {
		Collection<Editorial> editorials;

		editorials = editorialRepository.findAll();

		return editorials;
	}
	
	public void deleteById(int id) {
		editorialRepository.deleteById(id);
	}

}
