package com.myboot.datajpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student")
public class StudentEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Long id;
	
	@Column(unique = true)
	private Integer code;
	private String name;
	private Integer age;
	private String grade;
	private String daynight;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id")
	private DeptEntity dept;
	
	@OneToMany(mappedBy = "student")
	private List<CourseStatusEntity> courseStatus = new ArrayList<>();;
	
	public StudentEntity() {
		
	}
	
	public StudentEntity(Integer code, String name, Integer age, String grade, String daynight) {
		this.code = code;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.daynight = daynight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDaynight() {
		return daynight;
	}

	public void setDaynight(String daynight) {
		this.daynight = daynight;
	}
	
	public DeptEntity getDept() {
		return dept;
	}

	public void setDept(DeptEntity dept) {
		this.dept = dept;
	}
	
	public List<CourseStatusEntity> getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(List<CourseStatusEntity> courseStatus) {
		this.courseStatus = courseStatus;
	}	

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", code=" + code + ", name=" + name + ", age=" + age + ", grade=" + grade
				+ ", daynight=" + daynight + ", dept=" + dept + "]";
	}

}
