
package acme.com.domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Editorial extends DomainEntity {

	// Attributes

	private String	name;
	private String	country;
	private String	email;


	// Constructors

	public Editorial() {
		super();

		books = new HashSet<Book>();
	}
	public Editorial(String name, String country, String email) {
		this.name = name;
		this.country = country;
		this.email = email;

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
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// toString method

	@Override
	public String toString() {
		return "Editorial [name=" + name + ", country=" + country + ", email=" + email + "]";
	}


	// Relationships

	private Collection<Book> books;


	@OneToMany(mappedBy = "editorial")
	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}

	public void addBook(Book book) {
		books.add(book);
		book.setEditorial(this);
	}

}
