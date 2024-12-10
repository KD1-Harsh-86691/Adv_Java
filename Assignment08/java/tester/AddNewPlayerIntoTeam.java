package com.cdac.tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.daos.PlayerDao;
import com.cdac.daos.PlayerDaoImpl;
import com.cdac.entities.Player;
import com.cdac.utils.HibernateUtils;

public class AddNewPlayerIntoTeam {
	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			
			PlayerDao pDao = new PlayerDaoImpl();

			System.out.print("Enter team id");
			Long teamId = sc.nextLong();
			System.out.print("Enter first name : ");
			String fName = sc.next();
			System.out.print("Enter last name : ");
			String lName = sc.next();
			System.out.print("Enter dob : ");
			LocalDate dob = LocalDate.parse(sc.next());
			System.out.print("Enter batting avg : ");
			double battingAvg = sc.nextDouble();
			System.out.print("Enter wickets taken : ");
			int wickets = sc.nextInt();

			Player player = new Player(fName, lName, dob, battingAvg, wickets);

			System.out.println(pDao.addNewPlayer(teamId, player));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
