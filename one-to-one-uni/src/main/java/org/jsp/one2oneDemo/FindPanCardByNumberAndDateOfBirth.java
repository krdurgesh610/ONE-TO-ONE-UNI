package org.jsp.one2oneDemo;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPanCardByNumberAndDateOfBirth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number");
		String number = sc.next();
		System.out.println("Enter the DOB Formate(yyyy-mm-dd)");
		LocalDate dob = LocalDate.parse(sc.next());
		String pc3 = "select pc from PanCard pc where pc.number=?1 and pc.dob=?2";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery(pc3);
		q.setParameter(1, number);
		q.setParameter(2, dob);
		try {
			PanCard pc = (PanCard) q.getSingleResult();
			System.out.println(pc);
//			System.out.println(pc.getPincode());
		} catch (NoResultException e) {
			System.err.println("Invalid Detais Entered");
		}
	}
}
