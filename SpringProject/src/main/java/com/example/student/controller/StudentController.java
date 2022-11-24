package com.example.student.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.student.dto.StudentDto;
import com.example.student.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welocmepage() {
		return "index";
	}

	@RequestMapping(value = "/addStudents", method = RequestMethod.GET)
	public ModelAndView addStudent() {
		ModelAndView model = new ModelAndView();
		StudentDto student = new StudentDto();
		model.addObject("studentForm", student);
		List<String> list = studentService.getDetailsForSave();
		model.addObject("deparment", list);
		model.setViewName("savepage");
		return model;
	}

	@RequestMapping(value = "/saveStudentDetails", method = RequestMethod.POST)
	public ModelAndView saveStudentDetails(HttpServletRequest request,
			@Valid @ModelAttribute("studentForm") StudentDto student, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		if (bindingResult.hasErrors()) {
			
		} else {
			studentService.saveDetails(request, student);
			StudentDto studentDto = new StudentDto();
			model.addObject("studentForm", studentDto);
		}
		List<String> list = studentService.getDetailsForSave();
		model.addObject("deparment", list);
		model.setViewName("savepage");

		return model;

	}

	@RequestMapping(value = "/ListOfStudents", method = RequestMethod.GET)
	public ModelAndView getListOfStudentDetails() {
		ModelAndView model = new ModelAndView();
		List<StudentDto> studentDtoList = studentService.getStudentList();
		model.addObject("listStudents", studentDtoList);
		model.setViewName("listpage");
		return model;
	}

	@RequestMapping(value = "/StudentDetailsBasedOnId", method = RequestMethod.GET)
	public ModelAndView getStudentDetailsBasedOnId(@RequestParam("id") long id) {
		System.out.println(id);
		StudentDto studentDto = studentService.getStudentDetailsbasedonId(id);
		ModelAndView model = new ModelAndView();
		model.addObject("studentData", studentDto);
		model.setViewName("profile");
		return model;

	}
}
