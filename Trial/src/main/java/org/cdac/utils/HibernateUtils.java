package org.cdac.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory factory;
	
	public static void init() {
		factory = new Configuration().buildSessionFactory();
	}

	public static SessionFactory getFactory() {
		return factory;
	}

	public static void shutdown() {
		if(factory != null) {
			factory.close();
		}
	}
	
}
