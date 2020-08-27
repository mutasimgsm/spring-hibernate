package com.etircode;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.etircode.entity.Student;

public class StudentTrackerApp {

	static Logger myLogger;
	
	public static void main(String[] args) {
		
		myLogger = Logger.getLogger(StudentTrackerApp.class.getName());
		myLogger.setLevel(Level.INFO);

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start session
			session.beginTransaction();

			// createStudent(factory, session);
			
			 updateStudent( session);
			
			// getStudents(session);
			
			// deleteStudent(session);

			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
	private static void deleteStudent(Session session) {
		// get student from database
		int id = 1;
		Student dbStudent = session.get(Student.class, id);

		if (dbStudent != null) {
			// remove student
			session.delete(dbStudent);
			myLogger.info("stApp - Done");
	
		} else {
			System.out.println("No student found with a given id: "+ id + "!");
		}	
}
	
	private static void getStudents(Session session) {
		// get student from database
		List<Student> students = session.createQuery("from Student").list();

		if (students != null) {
			System.out.println(students.toString());
			System.out.println("stApp - Done");
	
		} else {
			System.out.println("No student found!");
		}	
}

	
	private static void updateStudent(Session session) {
			// get student from database
//			int id = 2;
//			Student dbStudent = session.get(Student.class, id);
			
			session.createQuery("update Student set email='foo@gmail.com'")
			.executeUpdate();
//
//			if (dbStudent != null) {
//				// set the value
//				dbStudent.setFirstName("Zeba");
//				dbStudent.setLastName("GSM");
//				dbStudent.setEmail("zeba@etir.com");
//				session.update(dbStudent);
//				myLogger.info("stApp - Done");
//		
//			} else {
//				System.out.println("No student found with a given id: "+ id + "!");
//			}	
	}

	private static void createStudent(Session session) {
		// create java object
		Student student = new Student("Zeba", "mohammed", "zeba@etir.com");

			// save object
			session.save(student);

			System.out.println("Done!");
		
	}

}
