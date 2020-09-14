package com.etir.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.etir.hibernate.demo.entity.Image;
import com.etir.hibernate.demo.entity.Student;

public class HibernateAdvanceApp {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Image.class)
				.buildSessionFactory();

		// create current session
		Session session = factory.getCurrentSession();

		// create objects
		Student student = new Student("Ahmed", "Omer", "ahmed@yahoo.com");

		List<String> images = student.getImages();

		images.add("poto1.jpg");
		images.add("poto2.jpg");
		images.add("poto3.jpg");
		images.add("poto3.jpg");
		images.add("poto4.jpg");

		// start session
		session.beginTransaction();

		// save object
		session.save(student);

		session.getTransaction().commit();
		// end the session

	}

}
