
package acme.com.domain.datatypes;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Embeddable
@Access(AccessType.PROPERTY)
public class Money {

	// Attributes

	private double	amount;
	private String	currency;


	// Constructors

	public Money() {
		super();
	}

	public Money(double amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	// Getters & Setters
	@Min(0)
	@Digits(integer = 9, fraction = 2)
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@NotBlank
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	// Ancillary methods

	public Money add(Money money) {
		Money resp = null;

		if (money.currency == currency) {
			resp = new Money();
			resp.amount = amount + money.amount;
			resp.currency = currency;
		}

		return resp;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}
	
}
