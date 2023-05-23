package com.myboot.datajpa.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.myboot.datajpa.entity.CourseEntity;
import com.myboot.datajpa.entity.CourseStatusEntity;
import com.myboot.datajpa.entity.StudentEntity;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CourseStatusVO {

	private Long id;

	@JsonIgnore
	private StudentVO student;

	private String studentName;

	private CourseVO course;

	private Integer score;

	public CourseStatusVO() { }

	public CourseStatusVO(StudentVO student, CourseVO course, Integer score) {
		this.student = student;
		this.course = course;
		this.score = score;
	}

	public CourseStatusVO(Long id, StudentVO student, CourseVO course, Integer score) {
		this(student,course,score);
		this.id = id;
	}
	
	public CourseStatusVO(CourseStatusEntity statusEntity) {
		id = statusEntity.getId();
		CourseEntity courseEntity = statusEntity.getCourse();
		course = new CourseVO(
				courseEntity.getId(),
				courseEntity.getCode(),
				courseEntity.getName(),
				courseEntity.getInstructor());
		score = statusEntity.getScore();
	}

	public CourseStatusVO(CourseStatusEntity statusEntity, StudentEntity studentEntity) {
		this(statusEntity);
		student = new StudentVO();
		student.setCode(studentEntity.getCode());
		student.setName(studentEntity.getName());

		this.studentName = studentEntity.getName();
		
	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public StudentVO getStudent() {
//		return student;
//	}
//
//	public void setStudent(StudentVO student) {
//		this.student = student;
//	}
//
//	public CourseVO getCourse() {
//		return course;
//	}
//
//	public void setCourse(CourseVO course) {
//		this.course = course;
//	}
//
//	public Integer getScore() {
//		return score;
//	}
//
//	public void setScore(Integer score) {
//		this.score = score;
//	}
//
//	public String getStudentName() {
//		return studentName;
//	}
//
//	public void setStudentName(String studentName) {
//		this.studentName = studentName;
//	}
//
//	@Override
//	public String toString() {
//		return "CourseStatusVO [id=" + id + ", course=" + course + ", score=" + score + "]";
//	}
//
}
