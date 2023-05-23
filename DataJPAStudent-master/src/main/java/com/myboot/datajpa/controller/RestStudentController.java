package com.myboot.datajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myboot.datajpa.entity.StudentEntity;
import com.myboot.datajpa.service.StudentService;
import com.myboot.datajpa.vo.CourseStatusVO;
import com.myboot.datajpa.vo.StudentVO;

@RestController
@RequestMapping("/students")
public class RestStudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/{code}")
	public StudentVO getStudent(@PathVariable Integer code) throws Exception {
		StudentVO student = studentService.getStudent(code);		
		return student;
	}
	
	@GetMapping("/course/{code}")
	public List<CourseStatusVO> getCourseStatus(@PathVariable Integer code) throws Exception {
		return studentService.getCourseStatus(code);		
	}
	
	@GetMapping("/bad/{code}")
	public StudentEntity getStudentBad(@PathVariable Integer code) throws Exception {
		return studentService.getStudentEntity(code);
	}
	
}
