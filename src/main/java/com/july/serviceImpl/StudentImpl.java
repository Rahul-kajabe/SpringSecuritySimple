package com.july.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.july.model.Student;
import com.july.repo.StudentRepo;
import com.july.service.StudentService;
@Service
public class StudentImpl implements StudentService{
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Optional<Student> getStudentDetailsById(int id) {
		
		return studentRepo.findById(id);
	}

	@Override
	public Student saveStudentDetails(Student student) {
		
		return studentRepo.save(student);
	}
	

}
