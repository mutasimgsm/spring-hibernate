package com.etircode;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.etircode.entity.Course;
import com.etircode.entity.Instructor;
import com.etircode.entity.InstructorDetail;
import com.etircode.entity.Review;
import com.etircode.entity.Student;

public class CourseApplication {


	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

//	  createCourseAndInstructor(factory, session);

		 getCoursesAndInstructors(factory, session);

//		 deleteCoursesAndInstructors(factory, session);

	}

	private static void getCoursesAndInstructors(SessionFactory factory, Session session) {
		try {
			session.beginTransaction();

//			List<Instructor> instructors = session.createQuery("from Instructor").list();
			List<Course> courses = session.createQuery("from Course").list();

			System.out.println("Courses: " + courses);
			System.out.println("Courses: ");
			for(Course course: courses) {
				System.out.println(course.getStudents());
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
		
		Student theStudent1 = new Student("Omer", "Awad", "omer@yahoo.com");
		Student theStudent2 = new Student("Rana", "Adbu", "rana@yahoo.com");

		try {
			session.beginTransaction();
			
			theInstructor1.setInstructorDetail(theInstructorDetai11);
			theInstructor2.setInstructorDetail(theInstructorDetail2);
		
			theCourse1.addReview(theReview1);
			theCourse1.addStudent(theStudent1);
			theCourse1.addStudent(theStudent2);
			
			theCourse2.addReview(theReview2);
			theCourse2.addReview(theReview3);
			theCourse2.addStudent(theStudent2);
			
			theCourse3.addReview(theReview4);
			
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
