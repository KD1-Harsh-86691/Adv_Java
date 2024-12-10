package com.cdac.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.daos.TeamDao;
import com.cdac.daos.TeamDaoImpl;
import com.cdac.utils.HibernateUtils;

public class GetOwnerNameAndAbbreviation {
	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			// create user dao instance
			TeamDao tDao = new TeamDaoImpl();
			System.out.println("Enter max age : ");
			int age = sc.nextInt();
			System.out.println("Enter batting avg : ");
			double average = sc.nextDouble();

			tDao.getDisplayOwnerNameAndAbbreviation(age, average)
					.forEach(t -> System.out.println(t.getOwner() + "\t" + t.getAbbreviation()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
