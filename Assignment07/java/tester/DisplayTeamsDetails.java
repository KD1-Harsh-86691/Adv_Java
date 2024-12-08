package com.cdac.tester;

import org.hibernate.SessionFactory;
import static com.cdac.utils.HibernateUtils.getSessionFactory;
import com.cdac.daos.TeamDao;
import com.cdac.daos.TeamDaoImpl;

public class DisplayTeamsDetails {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory()) {
			// Create dao instance
			TeamDao teamDao = new TeamDaoImpl();
			teamDao.getAllTeams().forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}
