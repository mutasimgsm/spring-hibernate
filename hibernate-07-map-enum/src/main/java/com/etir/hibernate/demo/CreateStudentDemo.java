package com.etir.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.etir.hibernate.demo.entity.Status;
import com.etir.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create current session
		Session session = factory.getCurrentSession();

		// create objects
		Student student1 = new Student("Ahmed", "Omer", "ahmed@yahoo.com", Status.ACTIVE);
		Student student2 = new Student("Marry", "Public", "public.marry@yahoo.com", Status.INACTIVE);
		
		
		// start session
		session.beginTransaction();

		// save object
		System.out.println("Saving the student...");
		session.save(student1);
		session.save(student2);

		session.getTransaction().commit();
		// end the session
		System.out.println("Done!");
	}

}
