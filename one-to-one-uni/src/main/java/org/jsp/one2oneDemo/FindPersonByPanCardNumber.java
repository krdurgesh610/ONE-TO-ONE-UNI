package org.jsp.one2oneDemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByPanCardNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter PanCard Number to Fetch Details");
		String number = sc.next();
		String qry = "select p from Person p where p.card.number=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, number);
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println("Person Id :-" + p.getId());
			System.out.println("Person Name :-" + p.getName());
			System.out.println("Person Phone :-" + p.getPhone());
		} catch (NoResultException e) {
			System.err.println("Inavlid PanCard Number");
		}
	}
}
