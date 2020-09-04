
package acme.com.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import acme.com.domain.Review;
import acme.com.repositories.ReviewRepository;

@Service
@Transactional
public class ReviewService {

	// Managed repository -------------------------------

	@Autowired
	private ReviewRepository reviewRepository;

	// Supporting services ------------------------------


	// Constructors -------------------------------------

	public ReviewService() {
		super();
	}

	// Simple CRUD methods

	public Review create() {
		Review result;

		result = new Review();

		return result;
	}

	public void save(Review review) {
		reviewRepository.save(review);
	}

	public Collection<Review> findAll() {
		Collection<Review> reviews;

		reviews = reviewRepository.findAll();

		return reviews;
	}
	
	public void deleteById(int id) {
		reviewRepository.deleteById(id);
	}

}
