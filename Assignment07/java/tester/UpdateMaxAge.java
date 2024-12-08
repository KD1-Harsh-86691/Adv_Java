package com.cdac.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.daos.TeamDao;
import com.cdac.daos.TeamDaoImpl;
import static com.cdac.utils.HibernateUtils.getSessionFactory;


public class UpdateMaxAge {
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			// create user dao instance
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter Team name : ");
			String name = sc.nextLine();
			System.out.println("Enter Max Age : ");
			int age = sc.nextInt();
			String msg = teamDao.updateMaxAge(name,age);
			System.out.println(msg);
			
		} 

	}
}
