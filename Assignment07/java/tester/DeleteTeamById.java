package com.cdac.tester;

import java.util.Scanner;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import org.hibernate.SessionFactory;

import com.cdac.daos.TeamDao;
import com.cdac.daos.TeamDaoImpl;

public class DeleteTeamById {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			// create team dao instance
			TeamDao userDao = new TeamDaoImpl();
			System.out.println("Enter team id to delete");
			System.out.println(userDao.deleteTeam(sc.nextLong()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
