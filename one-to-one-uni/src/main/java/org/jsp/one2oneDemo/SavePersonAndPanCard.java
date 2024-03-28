package org.jsp.one2oneDemo;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePersonAndPanCard {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Person p = new Person();
		p.setName("Ankit");
		p.setPhone(111555555L);

		PanCard card = new PanCard();
		card.setNumber("ABCD456E");
		card.setDob(LocalDate.parse("1920-05-12"));
		card.setPincode(847226);

		p.setCard(card);
		manager.persist(p);
		manager.persist(card);
		transaction.begin();
		transaction.commit();
	}
}
