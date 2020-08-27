package com.etircode.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "youtube_channel")
	private String youtubeChannle;

	@Column(name = "hobby")
	private String hobby;

	@OneToOne(mappedBy = "instructorDetail")
	private Instructor instructor;

	public InstructorDetail() {
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		super();
		this.youtubeChannle = youtubeChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getYoutubeChannle() {
		return youtubeChannle;
	}

	public void setYoutubeChannle(String youtubeChannle) {
		this.youtubeChannle = youtubeChannle;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtube_channel=" + youtubeChannle + ", hobby=" + hobby + "]";
	}
}
