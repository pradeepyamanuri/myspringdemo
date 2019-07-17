package com.slnst.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.slnst.hibernate.demo.entity.Instructor;
import com.slnst.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start transaction
			session.beginTransaction();
			
			int theid = 3;
			Instructor in = session.get(Instructor.class, theid);
			
			System.out.println("Found instructor: "+in);
			
			if(in != null) {
				System.out.println("Deleteing instructor: "+in);
				
				session.delete(in);
			}
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!!!");
		}
		finally {
			factory.close();
		}

	}

}
