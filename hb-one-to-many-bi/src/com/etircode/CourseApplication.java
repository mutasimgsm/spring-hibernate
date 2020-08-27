package com.etircode;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.etircode.entity.Course;
import com.etircode.entity.Instructor;

public class CourseApplication {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

//		  createCourseAndInstructor(factory, session);

//		 getCoursesAndInstructors(factory, session);

		 deleteCoursesAndInstructors(factory, session);

	}

	private static void getCoursesAndInstructors(SessionFactory factory, Session session) {
		try {
			session.beginTransaction();

			List<Instructor> instructors = session.createQuery("from Instructor").list();

			System.out.println("Instructors: " + instructors);
			System.out.println("Courses: ");
			for(Instructor instructor: instructors) {
				System.out.println(instructor.getCourses());
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void deleteCoursesAndInstructors(SessionFactory factory, Session session) {
		try {
			session.beginTransaction();
			int theId = 1;
			Course course = session.get(Course.class, theId);

			System.out.println("action>> ");

			session.delete(course);

			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createCourseAndInstructor(SessionFactory factory, Session session) {

//		Instructor theInstructor2 = new Instructor("Zeba", "Mohammed", "zeb_moh@yahoo.com");

		Course theCourse1 = new Course("Nodejs and Angular");

		Course theCourse2 = new Course("Financial managememt");

//		Course theCourse3 = new Course("Angular & Java for web developer");

		try {
			session.beginTransaction();

			Instructor theInstructor1 = session.get(Instructor.class, 1);
			

			theInstructor1.add(theCourse1);
			
			session.save(theCourse1);
	

			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
