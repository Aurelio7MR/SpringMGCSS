
package acme.com.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import acme.com.domain.Customer;
import acme.com.repositories.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	// Managed repository -------------------------------

	@Autowired
	private CustomerRepository customerRepository;

	// Supporting services ------------------------------


	// Constructors -------------------------------------

	public CustomerService() {
		super();
	}

	// Simple CRUD methods

	public Customer create() {
		Customer result;

		result = new Customer();

		return result;
	}

	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	public Collection<Customer> findAll() {
		Collection<Customer> customers;

		customers = customerRepository.findAll();

		return customers;
	}
	
	public void deleteById(int id) {
		customerRepository.deleteById(id);
	}

}
