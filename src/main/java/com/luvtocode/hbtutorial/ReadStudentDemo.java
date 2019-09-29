package com.luvtocode.hbtutorial;

import static com.luvtocode.hbtutorial.utility.SessionFactoryUtils.getSessionFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luvtocode.hbtutorial.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// Get session factory and session object
		SessionFactory factory = getSessionFactory();
		Session session = factory.getCurrentSession();

		// begin the trasaction
		session.beginTransaction();

		Student student = (Student) session.createQuery("from Student where firstName='Tushar'").getSingleResult();
		System.out.println("Read student by name :");
		System.out.println(student);
		
		System.out.println("List all students : ");
		List<Student> students = session.createQuery("from Student").getResultList();
		System.out.println(students);
		
		session.getTransaction().commit();
		// close the session
		session.close();
		factory.close();
	}
}
