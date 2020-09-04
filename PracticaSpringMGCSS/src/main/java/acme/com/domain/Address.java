
package acme.com.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Address extends DomainEntity {

	// Attributes

	private String	direction;
	private int		num;
	private String	city;


	// Constructors

	public Address() {
		super();

	}

	public Address(String direction, int num, String city) {
		this.direction = direction;
		this.num = num;
		this.city = city;
	}

	// Getters & Setters

	@NotBlank
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Min(1)
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@NotBlank
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	// toString method
	@Override
	public String toString() {
		return "Address [direction=" + direction + ", num=" + num + ", city=" + city + "]";
	}


	// Relationships

	private Customer customer;


	@OneToOne(optional = false)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
