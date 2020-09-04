package acme.com.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
@Access(AccessType.PROPERTY)
public class Review extends DomainEntity{

	private double score;
	private String description;
	private Book book;
	
	public Review() {
		super();
	}
	
	public Review(double score, String description) {
		super();
		this.score = score;
		this.description = description;
	}
	
	@NotBlank
	@Range(min=0, max=100)
	public double getScore() {
		return score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToOne(optional = true)
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	@Override
	public String toString() {
		return "Review [score=" + score + ", description=" + description + ", book=" + book + "]";
	}
	
	
	
}
