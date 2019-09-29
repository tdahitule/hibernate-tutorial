package com.luvtocode.hbtutorial;
import static com.luvtocode.hbtutorial.utility.SessionFactoryUtils.getSessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luvtocode.hbtutorial.entity.Student;
public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Student theStudent = (Student) session.createQuery("from Student where firstName='Tushar'").getSingleResult();
			
			theStudent.setEmail("mr.dtushar@gmail.com");
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}
	}

}
