package org.jsp.one2oneDemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByPanCardId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the PanCard Id to Fetch Details");
		int id = sc.nextInt();
		String qry = "select p from Person p where p.card.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println(p);
		} catch (NoResultException e) {
			System.err.println("Invalid PanCard id");
		}
	}
}
