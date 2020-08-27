package com.etircode;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.etircode.entity.Instructor;
import com.etircode.entity.InstructorDetail;

public class StudentTrackerApp {

	static Logger myLogger;
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create objects
		Instructor instructor = new Instructor("Ahmed", "yahya", "yahya@etir.com");
		
		InstructorDetail instructorDetail = new InstructorDetail("www://youtube.com/omer", "Swimming");
		
		

		// create session
		Session session = factory.getCurrentSession();
		
		

		try {
			// start session
			session.beginTransaction();
			
//			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 4);
			// add instructor detail and save
			instructor.setInstructorDetail(instructorDetail);
			session.save(instructor);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
}