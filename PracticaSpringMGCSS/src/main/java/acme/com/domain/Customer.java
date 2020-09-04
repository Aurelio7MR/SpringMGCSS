
package acme.com.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Customer extends DomainEntity {

	// Attributes

	private String	name;
	private String	surname;


	// Constructors

	public Customer() {
		super();

		books = new HashSet<Book>();
	}

	public Customer(String name, String surname) {
		this.name = name;
		this.surname = surname;

		books = new HashSet<Book>();
	}

	// Getters & Setters

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	// toString method

	@Override
	public String toString() {
		return "Customer [name=" + name + ", surname=" + surname + "]";
	}


	// Relationships

	private Collection<Book> books;


	@ManyToMany
	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}

	public void addBook(Book book) {
		books.add(book);
	}


	private Address address;


	@OneToOne(optional = true)
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
