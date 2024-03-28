package org.jsp.one2oneDemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FinfPersonByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Name to Fetch All details");
		String name = sc.next();
		String jpa2 = "select p from Person p where p.name=?1";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery(jpa2);
		q.setParameter(1, name);
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println(p.getId());
			System.out.println(p.getName());
			System.out.println(p.getPhone());
		} catch (NoResultException e) {
			System.err.println("Invalid Name Can't Fetch Details");
		}
	}

}
