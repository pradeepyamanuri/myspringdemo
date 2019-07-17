package com.slnst.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.slnst.hibernate.demo.entity.Instructor;
import com.slnst.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

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
			/*Instructor ti = new Instructor("pradeep","yamanuri","pradeepyamanuri@gmail.com");
			InstructorDetail tid = new InstructorDetail(
					"http://www.slnst.com/youtube","love to code");*/
			
			Instructor ti = new Instructor("madhu","kaka","madhukaka@gmail.com");
			InstructorDetail tid = new InstructorDetail(
					"http://www.youtube.com/madhukaka","eating");
			
			ti.setInstructorDetail(tid);
			//start transaction
			session.beginTransaction();
			
			System.out.println("saving instructor: "+ti);
			session.save(ti);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!!!");
		}
		finally {
			factory.close();
		}

	}

}
