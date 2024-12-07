package com.cdac.daos;

import com.cdac.entities.Teams;
import org.hibernate.*;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String signUpTeam(Teams teams) {
		String mesg = "Team registration failed!!!!!!!!!!";

		Session session = getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();
		try {
			Serializable teamId = session.save(teams);
			tx.commit();
			mesg = "User signed up ! , ID " + teamId;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
