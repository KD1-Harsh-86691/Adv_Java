package com.cdac.tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import static com.cdac.utils.HibernateUtils.getSessionFactory;
import com.cdac.daos.TeamDao;
import com.cdac.daos.TeamDaoImpl;

public class DisplayTeamsWithOwnerAndAbbrev
{
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
		Scanner sc=new Scanner(System.in)) {
			//create user dao instance
			TeamDao userDao=new TeamDaoImpl();
			System.out.println("Enter Max Age and Batting Average: ");			
			userDao.getDisplayOwnerNameAndAbbreviation(sc.nextInt(),sc.nextDouble()
					).forEach(t -> System.out.println(t.getOwner() +" "+ t.getAbbreviation()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
