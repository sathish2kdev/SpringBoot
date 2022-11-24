package com.example.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "image_master")
public class ImageMasterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_image_id")
	private Long studentImageId;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private StudentEntity studentId;

	@Column(name = "student_image")
	private String studentImage;

	public Long getStudentImageId() {
		return studentImageId;
	}

	public void setStudentImageId(Long studentImageId) {
		this.studentImageId = studentImageId;
	}

	public StudentEntity getStudentId() {
		return studentId;
	}

	public void setStudentId(StudentEntity studentId) {
		this.studentId = studentId;
	}

	public String getStudentImage() {
		return studentImage;
	}

	public void setStudentImage(String studentImage) {
		this.studentImage = studentImage;
	}

}
