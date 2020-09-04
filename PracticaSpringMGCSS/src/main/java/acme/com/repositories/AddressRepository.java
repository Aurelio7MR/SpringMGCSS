package acme.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acme.com.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
