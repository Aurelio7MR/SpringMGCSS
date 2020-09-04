package acme.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acme.com.domain.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer> {

}
