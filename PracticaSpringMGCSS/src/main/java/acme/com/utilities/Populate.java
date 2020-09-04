
package acme.com.utilities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import acme.com.domain.Address;
import acme.com.domain.Book;
import acme.com.domain.Customer;
import acme.com.domain.Editorial;
import acme.com.domain.Review;
import acme.com.domain.datatypes.Money;

public class Populate {

	private static EntityManager		manager;
	private static EntityManagerFactory	emf;


	public static void main(final String[] args) {
		emf = Persistence.createEntityManagerFactory("PersistMySQL");

		InitialData();

		manager.close();
		emf.close();
	}

	@SuppressWarnings("unchecked")
	public static void InitialData() {
		manager = emf.createEntityManager();

		manager.getTransaction().begin();

		Money price1 = new Money(10, "EUR");
		Money price2 = new Money(20, "EUR");
		Money price3 = new Money(30, "EUR");
		Money price4 = new Money(40, "EUR");

		Address add1 = new Address("Address Direction 1", 1, "Address City 1");
		Address add2 = new Address("Address Direction 2", 2, "Address City 2");
		Address add3 = new Address("Address Direction 3", 3, "Address City 3");

		Editorial ed1 = new Editorial("Editorial Name 1", "Editorial Country 1", "editorialemai1@email.com");
		Editorial ed2 = new Editorial("Editorial Name 2", "Editorial Country 2", "editorialemai2@email.com");
		Editorial ed3 = new Editorial("Editorial Name 3", "Editorial Country 3", "editorialemai3@email.com");
		Editorial ed4 = new Editorial("Editorial Name 4", "Editorial Country 4", "editorialemai4@email.com");
		
		Book b1 = new Book();
		b1.setTitle("Book 1");
		b1.setYear(1975);
		b1.setPrice(price1);
		b1.setEditorial(ed1);
		
		Book b2 = new Book();
		b2.setTitle("Book Title 2");
		b2.setYear(2002);
		b2.setPrice(price2);
		b2.setEditorial(ed1);
		
		Book b3 = new Book();
		b3.setTitle("Book Title 3");
		b3.setYear(2003);
		b3.setPrice(price3);
		b3.setEditorial(ed2);
		
		Book b4 = new Book();
		b4.setTitle("Book Title 4");
		b4.setYear(2004);
		b4.setPrice(price4);
		b4.setEditorial(ed3);
		
		Customer c1 = new Customer("Customer Name 1", "Customer Surname 1");
		Customer c2 = new Customer("Customer Name 2", "Customer Surname 2");
		Customer c3 = new Customer("Customer Name 3", "Customer Surname 3");
		Customer c4 = new Customer("Customer Name 4", "Customer Surname 4");

		c1.setAddress(add1);
		c2.setAddress(add2);
		c3.setAddress(add3);
		add1.setCustomer(c1);
		add2.setCustomer(c2);
		add3.setCustomer(c3);

		Review r1 = new Review(100.0, "El mejor libro de todos");
		Review r2 = new Review(99.9, "Casi el mejor libro de todos");
		Review r3 = new Review(50.0, "Un libro muy mediocre");
		Review r4 = new Review(0.0, "El peor libro de todos");
		
		r1.setBook(b1);
		r2.setBook(b2);
		r3.setBook(b3);
		r4.setBook(b3);
		
		manager.persist(c1);
		manager.persist(c2);
		manager.persist(c3);
		manager.persist(c4);

		manager.persist(add1);
		manager.persist(add2);
		manager.persist(add3);

		manager.persist(ed1);
		manager.persist(ed2);
		manager.persist(ed3);
		manager.persist(ed4);

		manager.persist(r1);
		manager.persist(r2);
		manager.persist(r3);
		manager.persist(r4);
		
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		manager.persist(b4);

		c1.addBook(b1);
		b1.addCustomer(c1);

		c1.addBook(b2);
		b2.addCustomer(c1);

		c2.addBook(b3);
		b3.addCustomer(c2);
		c2.addBook(b4);
		b4.addCustomer(c2);

		c3.addBook(b4);
		b4.addCustomer(c3);

		b1.addReview(r1);
		b2.addReview(r2);
		b3.addReview(r3);
		b3.addReview(r4);
		
		ed1.addBook(b1);
		ed1.addBook(b2);
		ed2.addBook(b3);
		ed3.addBook(b4);

		try {
			manager.getTransaction().commit();

			List<Book> books = manager.createQuery("select b from Book b").getResultList();

			for (Book book : books)
				System.out.println(book.toString());

			System.out.println("\nPersistencia de datos realizada satisfactoriamente\n");
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println("ERROR: la persistencia de datos no se ha realizado satisfactoriamente.");
		}
	}

	public static EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		Populate.manager = manager;
	}

}
