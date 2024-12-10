package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.daos.TeamDao;
import com.cdac.daos.TeamDaoImpl;
import com.cdac.entities.Teams;

public class GetTeamAndPlayerDetails {
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			// create category dao instance
			TeamDao dao = new TeamDaoImpl();

			System.out.println("Enter team id to search");
			Long teamId = sc.nextLong();

			Teams teams = dao.getTeamAndPlayerDetails(teamId);

			System.out.println("Team");
			System.out.println(teams);
			System.out.println("Players");
			teams.getPlayers().forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
