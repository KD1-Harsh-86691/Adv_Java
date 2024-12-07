package com.cdac.tester;

import org.hibernate.SessionFactory;

import com.cdac.daos.TeamDao;
import com.cdac.daos.TeamDaoImpl;
import com.cdac.entities.Teams;
import com.cdac.utils.HibernateUtils;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

public class TeamRegistration {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			//create team dao instance
			TeamDao teamDao=new TeamDaoImpl();
			System.out.println("Enter user details - String Name, "
					+ "String Abbreviation, String owner, int maxPlayerAge, "
					+ "Double battingAverage, int wicketsTaken");
			Teams newTeam=new Teams(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), 
					sc.nextDouble(),sc.nextInt());
			System.out.println(teamDao.signUpTeam(newTeam));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
