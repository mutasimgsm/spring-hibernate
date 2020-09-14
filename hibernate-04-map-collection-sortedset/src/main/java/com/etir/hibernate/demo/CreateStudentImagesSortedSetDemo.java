package com.etir.hibernate.demo;

import java.awt.Image;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.etir.hibernate.demo.entity.Student;

public class CreateStudentImagesSortedSetDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Image.class)
				.buildSessionFactory();

		// create current session
		Session session = factory.getCurrentSession();

		try {
			// create objects
			Student student = new Student("Ahmed", "Omer", "ahmed@yahoo.com");

			Set<String> images = student.getImages();

			images.add("poto1.jpg");
			images.add("poto2.jpg");
			images.add("poto3.jpg");
			images.add("poto4.jpg");
			images.add("poto5.jpg");

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
