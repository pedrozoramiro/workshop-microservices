package com.example.demo;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentsServices;

import io.swagger.annotations.ApiOperation;

@RestController
@ExposesResourceFor(Student.class)
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentsServices studentsServices;
	
	@ApiOperation(value = "Recurso responsavél por prover todos os estudantes ", tags = "Estudantes")
	@GetMapping
	public Iterable<Resource<Student>> findAll() {
		studentsServices.init();		
		return studentsServices.findAll().stream().map(this::toResource).collect(Collectors.toList());
	}
	
	@ApiOperation(value = "Recurso responsavél por prover todos os estudantes ", tags = "Estudantes")
	@GetMapping("/name/{name}")
	public Iterable<Resource<Student>> findAll(@PathVariable String name) {
		studentsServices.init();		
		return studentsServices.findAllByName(name).stream().map(this::toResource).collect(Collectors.toList());
	}
	
	@ApiOperation(value = "Recurso responsavél por prover todos os estudantes ", tags = "Estudantes")
	@GetMapping("/birthday/{month}")
	public Iterable<Resource<Student>> findAllStudentsByMonthBirthday(@PathVariable Integer month) {
		studentsServices.init();		
		return studentsServices.findAllStudentsByMonthBirthday(month).stream().map(this::toResource).collect(Collectors.toList());
	}
	
	@ApiOperation(value = "Recurso responsavél por prover 1 estudante baseado em seu ID", tags = "Estudantes")
	@GetMapping("{id}")
	public Resource<Student> findOne(@PathVariable Long id) {
		return toResource(studentsServices.findOne(id));
	}
	
	@ApiOperation(value = "Recurso responsavél criar 1 estudante ", tags = "Estudantes")
	@PostMapping
	public Resource<Student> create(@RequestBody Student student) {
		return toResource(studentsServices.create(student));
	}

	@ApiOperation(value = "Recurso responsavél atualizar 1 estudante ", tags = "Estudantes")
	@PutMapping
	public Resource<Student> update(@RequestBody Student student) {
		return toResource(studentsServices.update(student));
	}


	@ApiOperation(value = "Recurso responsavél remover 1 estudante ", tags = "Estudantes")
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		studentsServices.delete(id);
	}

	
	private Resource<Student> toResource(Student student) {
		return new Resource<>(student,
				linkTo(methodOn(StudentController.class).findOne(student.getId())).withSelfRel(),
				linkTo(methodOn(StudentController.class).findAll()).withRel("students"));
	}
}
