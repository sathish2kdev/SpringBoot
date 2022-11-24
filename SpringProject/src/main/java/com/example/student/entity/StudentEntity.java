package com.example.student.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student_master")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Long studentId;

	@ManyToOne
	@JoinColumn(name = "department_id",referencedColumnName = "department_id")
	private DepartmentMasterEntity departmentId;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "student_roll_number")
	private String studentRollNumber;

	@Column(name = "date_of_joining")
	private Date dateOfJoining;

	@Column(name = "fees_paid_status")
	private String feesPaidStatus;

	@OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL, targetEntity = ImageMasterEntity.class)
	private List<ImageMasterEntity> image;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public DepartmentMasterEntity getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(DepartmentMasterEntity departmentId) {
		this.departmentId = departmentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentRollNumber() {
		return studentRollNumber;
	}

	public void setStudentRollNumber(String studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getFeesPaidStatus() {
		return feesPaidStatus;
	}

	public void setFeesPaidStatus(String feesPaidStatus) {
		this.feesPaidStatus = feesPaidStatus;
	}

	public List<ImageMasterEntity> getImage() {
		return image;
	}

	public void setImage(List<ImageMasterEntity> image) {
		this.image = image;
	}

}
