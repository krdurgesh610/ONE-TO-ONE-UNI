package org.jsp.one2oneDemo;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonById {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID to display Person details");
		int id = sc.nextInt();
		String jpa1 = "select p from Person p where p.id=?1";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery(jpa1);
		q.setParameter(1, id);
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println("Person Id:" + p.getId());
			System.out.println("Person Name:" + p.getName());
			System.out.println("Person Phone:" + p.getPhone());
		} catch (NoResultException e) {
			System.err.println("Invalid entered Id");
		}

	}

}
