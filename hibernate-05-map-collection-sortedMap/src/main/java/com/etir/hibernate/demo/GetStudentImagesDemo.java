package com.etir.hibernate.demo;

import java.awt.Image;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.etir.hibernate.demo.entity.Student;

public class GetStudentImagesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Image.class).buildSessionFactory();

		// create current session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int id = 1;
			
			Student student = session.get(Student.class, id);
			
			System.out.println("Student details: "+ student);

			System.out.println("The associated images: "+ student.getImages());
			session.getTransaction().commit();

			System.out.println("Done");
		} catch (Exception exc) {
			exc.getStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
