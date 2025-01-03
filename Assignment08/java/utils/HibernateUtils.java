package com.cdac.utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	
	static {
		System.out.println("In static initialization block...");
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	//getter
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
