package org.jsp.one2oneDemo;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByPanCardNumberAndDOB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter PanCard Number");
		String number = sc.next();
		System.out.println("Enter the DOB (yyyy-mm-dd)");
		String qry = "select p from Person p where p.card.number=?1 and p.card.dob=?2";
		LocalDate dob = LocalDate.parse(sc.next());
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, number);
		q.setParameter(2, dob);
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println("Person Id :-" + p.getId());
			System.out.println("Person Name :-" + p.getName());
			System.out.println("Person Phone :-" + p.getPhone());
		} catch (NoResultException e) {
			System.err.println("Invalid Entered Details");
		}
	}
}
