package com.myboot.datajpa.service;

import java.util.List;

import com.myboot.datajpa.entity.StudentEntity;
import com.myboot.datajpa.vo.CourseStatusVO;
import com.myboot.datajpa.vo.StudentVO;

public interface StudentService {
	public StudentVO getStudent(Integer code) throws Exception;
	
	public List<CourseStatusVO> getCourseStatus(Integer code) throws Exception;
	
	public StudentEntity getStudentEntity(Integer code) throws Exception;
	
}
