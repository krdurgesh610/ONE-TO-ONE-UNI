package org.jsp.one2oneDemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPanCardById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter PanCard Id ");
		int id = sc.nextInt();
		String pc1 = "select pc from PanCard pc where pc.id=?1";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery(pc1);
		q.setParameter(1, id);
		try {
			PanCard pc = (PanCard) q.getSingleResult();
			System.out.println(pc.getId());
			System.out.println(pc.getNumber());
			System.out.println(pc.getPincode());
			System.out.println(pc.getDob());
		} catch (NoResultException e) {
			System.err.println("Invalid Id .........!!!!");
		}
	}
}
