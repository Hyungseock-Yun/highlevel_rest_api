package com.myboot.datajpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class CourseEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Long id;
	
	@Column(unique = true)
	private Integer code;
	private String name;
	private String instructor;
	
	public CourseEntity() {
		
	}
	
	public CourseEntity(Integer code, String name, String instructor) {
		this.code = code;
		this.name = name;
		this.instructor = instructor;
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

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "CourseEntity [id=" + id + ", code=" + code + ", name=" + name + ", instructor=" + instructor + "]";
	}
	
}
