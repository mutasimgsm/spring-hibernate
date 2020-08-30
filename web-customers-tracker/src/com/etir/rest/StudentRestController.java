package com.etir.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etir.entity.Student;
import com.etir.exception.StudentErrorResponse;
import com.etir.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	List<Student> students;
	
	@PostConstruct
	public void loadData() {
		
		students = new ArrayList<>();
		
		students.add(new Student("Omer", "Awad"));
		students.add(new Student("Zeba", "Mohammed"));
		students.add(new Student("Hassan", "Yahya"));
		
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudents(@PathVariable int studentId) {
		
		if(studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - "+ studentId);
		}
		
		return students.get(studentId);
	}
	
}
