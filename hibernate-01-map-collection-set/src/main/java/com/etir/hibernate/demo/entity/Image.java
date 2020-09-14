package com.etir.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="image")
public class Image {

	@Column(name="student_id")
	private int studentId;
	
	@Column(name="file_name")
	private String fileName;
}
