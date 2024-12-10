package com.cdac.daos;

import java.util.Locale.Category;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entities.Player;
import com.cdac.entities.Teams;
import com.cdac.utils.HibernateUtils;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addNewPlayer(Long teamId, Player Player) {
		String mesg = "Adding player failed!!!!!";
		org.hibernate.Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		try {
			Teams team = session.get(Teams.class, teamId);
			if (team != null) {
				team.addPlayer(Player);
				session.persist(Player); // required since - no cascading still!!!!
				tx.commit();
				mesg = "added new player , id=" + Player.getId();
			} else {
				System.out.println("Id is not matched....");
			}

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public String deletePlayerFromTeam(long teamId, long playerId) {
		String mesg = "Deleting player failed!!!!!";

		org.hibernate.Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		try {
			Teams team = session.get(Teams.class, teamId);
			Player player = session.get(Player.class, playerId);
			if (team != null && player != null) {

				team.removePlayer(player);
			} else {
				System.out.println("Id is not matched....");
			}
			tx.commit();
			mesg = "removed player";

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
