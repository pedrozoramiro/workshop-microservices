package com.example.workshop.microservices.students;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop.microservices.students.dto.StudentDTO;
import com.example.workshop.microservices.students.model.Student;
import com.example.workshop.microservices.students.repository.StudentsRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	
	@Autowired StudentsRepository repository;
	@Autowired  DiciplinesClient diciplinesClient;
	
	@GetMapping
	public List<Student> findAll() {
		return repository.findAll();
		
	}

	@GetMapping("{id}")
	public StudentDTO findOne(@PathVariable Long id) {
		StudentDTO student = new StudentDTO();
		student.setDisciplinas(diciplinesClient.findAllDiciplines());
		return student;
	}
}
