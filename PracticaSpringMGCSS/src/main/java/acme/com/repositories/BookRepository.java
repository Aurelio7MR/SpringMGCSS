package acme.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acme.com.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
