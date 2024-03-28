package org.jsp.one2oneDemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByPhone {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Phone to fetch the details");
	long phone = sc.nextLong();
	String jsp3 = "select p from Person p where p.phone=?1";
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();
	Query q = manager.createQuery(jsp3);
	q.setParameter(1, phone);
	try {
		Person p = (Person) q.getSingleResult();
		System.out.println(p.getId());
		System.out.println(p.getName());
	}
	catch(NoResultException e) {
		System.err.println("Invalid Phone Number Can't find Details");
	}
}
}
