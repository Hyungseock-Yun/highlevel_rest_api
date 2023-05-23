package com.myboot.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myboot.datajpa.entity.DeptEntity;

public interface DeptRepository extends JpaRepository<DeptEntity, Long>{
	
}
