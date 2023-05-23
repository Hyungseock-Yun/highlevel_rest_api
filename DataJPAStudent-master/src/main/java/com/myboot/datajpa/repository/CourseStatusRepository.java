package com.myboot.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myboot.datajpa.entity.CourseStatusEntity;
import com.myboot.datajpa.entity.StudentEntity;

public interface CourseStatusRepository extends JpaRepository<CourseStatusEntity, Long>{
	List<CourseStatusEntity> findByStudent(StudentEntity student);
}
