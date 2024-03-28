package org.jsp.one2oneDemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPanCardByPersonId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Person ID");
		int id = sc.nextInt();
		String qry = "select p.card from Person p where p.id=?1";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		try {
			PanCard p = (PanCard) q.getSingleResult();
			System.out.println(p.getId());
			System.out.println(p.getNumber());
			System.out.println(p.getPincode());
			System.out.println(p.getDob());
		} catch (NoResultException e) {
			System.err.println("Invalid Person Id");
		}
	}
}
