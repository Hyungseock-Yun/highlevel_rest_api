package com.myboot.datajpa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myboot.datajpa.entity.CourseStatusEntity;
import com.myboot.datajpa.entity.StudentEntity;
import com.myboot.datajpa.exception.BusinessException;
import com.myboot.datajpa.repository.CourseStatusRepository;
import com.myboot.datajpa.repository.DeptRepository;
import com.myboot.datajpa.repository.StudentRepository;
import com.myboot.datajpa.vo.CourseStatusVO;
import com.myboot.datajpa.vo.DeptVO;
import com.myboot.datajpa.vo.StudentVO;

@Service("studentService")
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	private final DeptRepository deptRepository;

	private final CourseStatusRepository statusRepository;

	private final ModelMapper modelMapper;
	
//	public StudentServiceImpl(StudentRepository studentRepository, DeptRepository deptRepository,
//														CourseStatusRepository statusRepository, ModelMapper modelMapper) {
//		this.studentRepository = studentRepository;
//		this.deptRepository = deptRepository;
//		this.statusRepository = statusRepository;
//		this.modelMapper = modelMapper;
//	}

	@Override
	public StudentVO getStudent(Integer code) throws Exception {
		
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		
		Optional<StudentEntity> optional = studentRepository.findByCode(code);
		if(optional.isEmpty())
			throw new BusinessException(code + " Student가 존재하지 않습니다.", HttpStatus.NOT_FOUND);

		StudentEntity student = optional.get();
		StudentVO studentVO = modelMapper.map(student, StudentVO.class);
		
		DeptVO deptVO = modelMapper.map(student.getDept(), DeptVO.class);
		studentVO.setDept(deptVO);
				
		List<CourseStatusEntity> statusList = student.getCourseStatus();
		System.out.println(statusList);
		
		List<CourseStatusVO> statusVoList = statusList.stream()
							.map(CourseStatusVO::new)
							.collect(Collectors.toList());
		studentVO.setCourseStatus(statusVoList);
		
		return studentVO;
	}
	
	@Override
	public List<CourseStatusVO> getCourseStatus(Integer code) throws Exception {
		Optional<StudentEntity> optional = studentRepository.findByCode(code);
		if(!optional.isPresent()) 
			throw new BusinessException(code + " Student가 존재하지 않습니다.", HttpStatus.NOT_FOUND);
		StudentEntity student = optional.get();
		
		List<CourseStatusEntity> statusList = statusRepository.findByStudent(student);
		
		List<CourseStatusVO> statusVoList = statusList.stream()
				.map(status -> new CourseStatusVO(status, status.getStudent()))
				.collect(Collectors.toList());
		
		return statusVoList;
	}
	@Override
	public StudentEntity getStudentEntity(Integer code) throws Exception {
		Optional<StudentEntity> optional = studentRepository.findByCode(code);
		if(!optional.isPresent()) 
			throw new BusinessException(code + " Student가 존재하지 않습니다.", HttpStatus.NOT_FOUND);
		StudentEntity student = optional.get();
		return student;
	}

}
