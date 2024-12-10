package com.cdac.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import com.cdac.daos.PlayerDao;
import com.cdac.daos.PlayerDaoImpl;

public class DeletePlayerFromTeam {
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			PlayerDao dao=new PlayerDaoImpl();
			System.out.println("Enter team id:");			
			System.out.println("Enter Player id:");	
			
			System.out.println(dao.deletePlayerFromTeam(sc.nextLong(),sc.nextLong()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
