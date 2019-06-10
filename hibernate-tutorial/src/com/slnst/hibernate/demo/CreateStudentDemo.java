package com.slnst.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.slnst.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save the java object
			System.out.println("creating new student object!!!!");
			Student tempStudent = new Student("pradeep","yamanuri","pradeepyamanuri@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving student object!!!");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!!!");
		}
		finally {
			factory.close();
		}

	}

}
