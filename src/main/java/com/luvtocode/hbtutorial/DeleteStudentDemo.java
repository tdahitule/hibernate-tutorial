package com.luvtocode.hbtutorial;

import static com.luvtocode.hbtutorial.utility.SessionFactoryUtils.getSessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luvtocode.hbtutorial.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Student theStudent = (Student) session.createQuery("from Student where dateOfBirth='Sagar'").getSingleResult();
			
			System.out.println(theStudent);
			session.delete(theStudent);
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}

}
