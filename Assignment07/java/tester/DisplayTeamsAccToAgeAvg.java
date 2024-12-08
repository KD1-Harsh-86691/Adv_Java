package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;
import org.hibernate.SessionFactory;
import com.cdac.utils.HibernateUtils;
import com.cdac.daos.TeamDao;
import com.cdac.daos.TeamDaoImpl;

public class DisplayTeamsAccToAgeAvg {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			// Create team dao instance
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter Max Age and Batting Average: ");
			teamDao.getDisplayTeamsAccAgeAvg(sc.nextInt(), sc.nextDouble()).forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
