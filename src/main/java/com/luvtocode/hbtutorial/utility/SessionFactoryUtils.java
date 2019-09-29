package com.luvtocode.hbtutorial.utility;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.luvtocode.hbtutorial.entity.Student;

public class SessionFactoryUtils {

	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration().configure();

			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

			sessionFactory =  configuration.addAnnotatedClass(Student.class).buildSessionFactory(sr);

		} catch (HibernateException he) {
			System.err.println("Error creating Session: " + he);
			throw new ExceptionInInitializerError(he);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
