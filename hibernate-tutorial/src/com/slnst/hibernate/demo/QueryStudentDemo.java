package com.slnst.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.slnst.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start transaction
			session.beginTransaction();

			// retrive students from db
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			displayStudents(theStudents);

			theStudents = session.createQuery("from Student s where s.lastName = 'chupki'").getResultList();
			displayStudents(theStudents);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!!!");
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
