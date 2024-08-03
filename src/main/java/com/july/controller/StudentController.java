package com.july.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.july.model.Student;
import com.july.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired(required = true)
	private StudentService stuService;

	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Student>> getStudentDetailsById(@PathVariable int id) {
		Optional<Student> resp = stuService.getStudentDetailsById(id);

		return ResponseEntity.ok(resp);

	}

	@PostMapping("/save")
	public ResponseEntity<String> saveStudentDetails(@RequestBody Student student) {

		/*
		 * if ((student.getExtraActivity() == null ||
		 * student.getExtraActivity().isEmpty()) && (student.getAcResults() == null ||
		 * student.getAcResults().isEmpty()) && student.getSports() == null ||
		 * student.getSports().isEmpty()) {
		 * 
		 * return ResponseEntity.badRequest().
		 * body("At least one related entity must be provided."); }
		 */

		Student savedStudent = stuService.saveStudentDetails(student);

		return ResponseEntity.ok("Student created with ID: " + savedStudent.getId());
	}

}