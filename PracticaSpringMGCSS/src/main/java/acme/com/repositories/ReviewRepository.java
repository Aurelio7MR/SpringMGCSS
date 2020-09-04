package acme.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acme.com.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
