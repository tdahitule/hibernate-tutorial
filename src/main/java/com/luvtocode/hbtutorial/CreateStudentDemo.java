package com.luvtocode.hbtutorial;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luvtocode.hbtutorial.entity.Student;
import com.luvtocode.hbtutorial.utility.DateUtils;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// Create SessionFactory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		// Get session object from factory
		Session session = factory.getCurrentSession();

		try {

			Date theDateOfBirth = DateUtils.parseDate("31/12/1992");

			// Create student object
			Student student = new Student("Sagar", "Patil", "imsagar@gmail.com", theDateOfBirth);

			// begin transaction
			session.beginTransaction();

			// save student object
			System.out.println("Saving student object...!!");
			session.save(student);
			System.out.println("Done..!!");

			System.out.println(session.get(Student.class, student.getId()));

			// commit transaction
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			// Close factory
			factory.close();
		}

	}

}
