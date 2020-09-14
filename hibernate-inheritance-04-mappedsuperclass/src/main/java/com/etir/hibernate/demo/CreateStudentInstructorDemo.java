package com.etir.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.etir.hibernate.demo.entity.Instructor;
import com.etir.hibernate.demo.entity.Student;
import com.etir.hibernate.demo.entity.User;

public class CreateStudentInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();

		// create current session
		Session session = factory.getCurrentSession();

		// create objects
		User student = new Student("Ahmed", "Omer", "ahmed@yahoo.com", "Hibernate");
		User instructor = new Instructor("Marry", "Public", "public.marry@yahoo.com", 20000.00);
		
		
		// start session
		session.beginTransaction();

		// save object
		System.out.println("Saving the student and instructor...");
		session.save(student);
		session.save(instructor);

		session.getTransaction().commit();
		// end the session
		System.out.println("Done!");
	}

}
