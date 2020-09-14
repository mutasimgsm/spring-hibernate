package com.etir.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.etir.hibernate.demo.entity.Address;
import com.etir.hibernate.demo.entity.Student;

public class CreateStudentAddressDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Address.class)
				.buildSessionFactory();

		// create current session
		Session session = factory.getCurrentSession();

		// create objects
		Student student = new Student("Ahmed", "Omer", "ahmed@yahoo.com");

		Address billingAddress = new Address("Some Billing Street", "Some Billing City", "112121212");
		
		// start session
		session.beginTransaction();

		// save object
		System.out.println("Saving the student and address...");
		student.setBillingAddress(billingAddress);
		session.save(student);

		session.getTransaction().commit();
		// end the session
		System.out.println("Done!");
	}

}
