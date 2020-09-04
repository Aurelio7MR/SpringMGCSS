
package acme.com.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import acme.com.domain.Address;
import acme.com.repositories.AddressRepository;

@Service
@Transactional
public class AddressService {

	// Managed repository -------------------------------

	@Autowired
	private AddressRepository addressRepository;

	// Supporting services ------------------------------


	// Constructors -------------------------------------

	public AddressService() {
		super();
	}

	// Simple CRUD methods

	public Address create() {
		Address result;

		result = new Address();

		return result;
	}

	public void save(Address address) {
		addressRepository.save(address);
	}

	public Collection<Address> findAll() {
		Collection<Address> addresses;

		addresses = addressRepository.findAll();

		return addresses;
	}

}
