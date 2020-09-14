package com.etir.hibernate.demo;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.etir.hibernate.demo.entity.Student;

public class SortedMpDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create current session
		Session session = factory.getCurrentSession();

		// create objects
		try {
			Student student = new Student("Ahmed", "Omer", "ahmed@yahoo.com");

			Map<String, String> images = student.getImages();

			images.put("photo1.jpg", "Photo 1");
			images.put("photo2.jpg", "Photo 2");
			images.put("photo3.jpg", "Photo 3");
			

			// start session
			session.beginTransaction();

			// save object
			session.save(student);

			session.getTransaction().commit();
			// end the session
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			session.close();
			factory.close();
		}

	}

}
