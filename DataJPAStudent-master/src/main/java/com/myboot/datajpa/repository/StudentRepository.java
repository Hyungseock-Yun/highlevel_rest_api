package com.myboot.datajpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myboot.datajpa.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{
	Optional<StudentEntity> findByCode(Integer code);
}
