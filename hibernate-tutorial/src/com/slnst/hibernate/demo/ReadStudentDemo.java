package com.slnst.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.slnst.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("chota","chupki","chotachupki@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving student object!!!");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			
			
			System.out.println("saved student genarated id: " + tempStudent.getId());
			
			//get new session and transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student bases on the primary key: id
			System.out.println("Getting student with id: " +tempStudent.getId());
			Student getStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + getStudent);
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!!");
		}
		finally {
			factory.close();
		}

	}

}
