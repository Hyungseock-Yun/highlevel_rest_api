package com.myboot.datajpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
public class DeptEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private Long id;
	
	@Column(unique = true)
	private Integer code;
	private String name;
	

	public DeptEntity() {
		
	}
	
	public DeptEntity(Integer code, String name) {
		this.code = code;
		this.name = name;
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

	@Override
	public String toString() {
		return "DeptVO [id=" + id + ", code=" + code + ", name=" + name + "]";
	}
	
}
