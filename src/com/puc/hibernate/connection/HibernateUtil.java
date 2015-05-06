package com.puc.hibernate.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	static {
		try {
			setFactory(new Configuration().configure().buildSessionFactory());
		} catch (Throwable e) {
			e.printStackTrace();
			setFactory(null);
		}
	}

	public static SessionFactory getFactory() {
		return factory;
	}

	private static void setFactory(SessionFactory factory) {
		HibernateUtil.factory = factory;
	}
}
