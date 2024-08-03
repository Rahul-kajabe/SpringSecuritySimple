package com.july.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.july.model.Student;

@Service
public interface StudentService {
	
	Optional<Student> getStudentDetailsById(int id);
	
	Student saveStudentDetails(Student student);

}
