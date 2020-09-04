
package acme.com.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import acme.com.domain.datatypes.Money;

@Entity
@Access(AccessType.PROPERTY)
public class Book extends DomainEntity {

	// Attributes

	private String	title;
	private int		year;
	private Money	price;

	// Constructors

	public Book() {
		super();

		customers = new HashSet<Customer>();
	}

	public Book(String title, int year, Money price) {
		this.title = title;
		this.year = year;
		this.price = price;

		customers = new HashSet<Customer>();
	}

	// Getter & Setters

	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Min(value = 1000)
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Valid
	@NotNull
	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

	// toString method

	@Override
	public String toString() {
		return "Book [title=" + title + ", year=" + year + ", price=" + price + "]";
	}


	// Relationships

	private Editorial editorial;


	@ManyToOne(optional = false)
	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}


	private Collection<Customer> customers;


	@ManyToMany(mappedBy = "books")
	public Collection<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Collection<Customer> customers) {
		this.customers = customers;
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	private Collection<Review> reviews = new ArrayList<Review>();

	@OneToMany(mappedBy = "book")
	public Collection<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Collection<Review> reviews) {
		this.reviews = reviews;
	}
	
	public void addReview(Review review) {
		reviews.add(review);
	}
	
}
