package com.etircode;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.etircode.entity.Course;
import com.etircode.entity.Instructor;
import com.etircode.entity.InstructorDetail;
import com.etircode.entity.Review;

public class CourseApplication {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
//	createCourseAndInstructor(factory, session);
		
	 //	getCoursesAndInstructors(factory, session);
		
		 deleteCoursesAndInstructors(factory, session);

	}
	
	private static void getCoursesAndInstructors(SessionFactory factory, Session session) {
		try {
			session.beginTransaction();
			
			List<Instructor> instructors = session.createQuery("from Instructor").list();
			
			System.out.println("Instructors: "+ instructors);
			for(Instructor instrucotr: instructors) {
				System.out.println("instructorDetail: "+ instrucotr.getInstructorDetail());
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
//			 Instructor instructor = session.get(Instructor.class, theId);
			 Course course = session.get(Course.class, theId);
//			 Review review = session.get(Review.class, theId);
			// int query = session.createQuery("delete from Review r where r.id=4").executeUpdate();
			
	//		int query = session.createQuery("delete Instructor i where i.id=1").executeUpdate();
			System.out.println("action>> ");
			
			session.delete(course);
	
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createCourseAndInstructor(SessionFactory factory, Session session) {
		
		Instructor theInstructor1 = new Instructor("Mutasim", "Younis", "mutasin@yahoo.com");
		InstructorDetail theInstructorDetai11 = new InstructorDetail("www://youtube.com/mutasim", "Swimming");
		
		
		Instructor theInstructor2 = new Instructor("Zeba", "Mohammed", "zeb_moh@yahoo.com");
		InstructorDetail theInstructorDetail2 = new InstructorDetail("www://youtube.com/zeba", "Writing");
		
		
		Course theCourse1 = new Course("Flutter for IOS nad Android Development");
		Review theReview1 = new Review("Good!");
		
		
		Course theCourse2 = new Course("Financial managememt");
		Review theReview2 = new Review("Great Course1");
		Review theReview3 = new Review("Awesome!");
		
		Course theCourse3 = new Course("Angular & Java for web developer");
		Review theReview4 = new Review("Wonderful course");

		try {
			session.beginTransaction();
			
			theInstructor1.setInstructorDetail(theInstructorDetai11);
			theInstructor2.setInstructorDetail(theInstructorDetail2);
		
			theCourse1.add(theReview1);
			
			theCourse2.add(theReview2);
			theCourse2.add(theReview3);
			
			theCourse3.add(theReview4);
			
			theCourse1.setInstructor(theInstructor1);
			theCourse2.setInstructor(theInstructor2);
			theCourse3.setInstructor(theInstructor1);
			
			session.save(theCourse1);
			session.save(theCourse3);
			session.save(theCourse2);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
