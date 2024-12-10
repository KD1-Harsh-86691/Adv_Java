package com.cdac.daos;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entities.Teams;
import com.cdac.utils.HibernateUtils;

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

	@Override
	public List<Teams> getAllTeams() {
		String jpql = "select t from Teams t";
		List<Teams> teams = null;
		// 1. Get Session from SF
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Teams.class).getResultList();
			// teams - list of persistent entities.
			tx.commit();
		} catch (RuntimeException e) {
			// roll back the transaction
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return teams;
	}

	@Override
	public List<Teams> getDisplayTeamsAccAgeAvg(int maxAge, double battingAvg) {
		List<Teams> teams = null;
		String jpql = "select t from Teams t where t.maxPlayerAge >:ma and t.battingAvg <:ba";
		// 1. get Session from SessionFactory
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Teams.class).setParameter("ma", maxAge).setParameter("ba", battingAvg)
					.getResultList();
			// list of persistent entities
			tx.commit();
		} catch (RuntimeException e) {
			// roll back the tx
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return teams;// list of detached entities
	}

	@Override
	public List<Teams> getDisplayOwnerNameAndAbbreviation(int maxAge, double battingAvg) {
		List<Teams> teams = null;
		String jpql = "select new com.cdac.entities.Teams(owner,abbreviation) from Teams t where t.maxPlayerAge<:age and t.battingAvg>:average";
		// 1. get Session from SessionFactory
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Teams.class).setParameter("age", maxAge).setParameter("average", battingAvg)
					.getResultList();
			// list of persistent entities
			tx.commit();
		} catch (RuntimeException e) {
			// roll back the tx
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return teams;// list of detached entities
	}
	
	@Override
	public String deleteTeam(Long userId) {
		String mesg="Team Deletion failed!!!!!!";
		Teams team = null;
		// 1. get Session from SessionFactory
		Session session=getSessionFactory().getCurrentSession();
		//2. Begin Tx
		Transaction tx=session.beginTransaction();
		try {
			//get 
			team=session.get(Teams.class, userId);
			if(team != null)
			{
				//team - persistent
				session.delete(team);
				mesg="Team Has Been Deleted!!!!!!";
			}
			tx.commit();
		} catch (RuntimeException e) {
			//roll back the tx
			if(tx != null)
				tx.rollback();
			//re throw the same exception to the caller
			throw e;
		}
	
		return mesg;
	}
	
	@Override
	public String updateMaxAge(String name , int age) {
		String msg = "team updation failed..";
		String jpqlString = "select t from Teams t where t.name=:tn";
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Teams team = session.createQuery(jpqlString, Teams.class).setParameter("tn", name).getSingleResult();
			team.setMaxPlayerAge(age);
			msg = "team updated successfully..";
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}
	
	@Override
	public Teams getTeamAndPlayerDetails(Long teamId) {
		
		Teams teams = null;
			
		String jpql = "select t from Teams t left join fetch t.players where t.id=:id";
			
			// 1. get session from SF (getCurrentSession)
			Session session = getSessionFactory().getCurrentSession();
			// 2. Begin a Tx
			Transaction tx = session.beginTransaction();
			try {
				teams = session.createQuery(jpql, Teams.class)
						.setParameter("id", teamId)
						.getSingleResult();//select - categories
				tx.commit();
			} catch (RuntimeException e) {
				if (tx != null)
					tx.rollback();
				throw e;
			}
			return teams;// detached

		}
	
	}

