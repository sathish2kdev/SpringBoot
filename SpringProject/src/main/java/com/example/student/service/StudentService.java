package com.example.student.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.student.dto.StudentDto;
import com.example.student.entity.StudentEntity;

public interface StudentService {

	List<String> getDetailsForSave();

	List<StudentDto> getStudentList();

	StudentEntity saveStudentsDetails(StudentDto studentDto);

	void saveDetails(HttpServletRequest request,StudentDto studentDto);

	StudentDto getStudentDetailsbasedonId(long id);
}
