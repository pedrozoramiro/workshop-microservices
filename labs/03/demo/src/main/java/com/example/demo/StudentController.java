package com.example.demo;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@ExposesResourceFor(Student.class)
@RequestMapping("/students")
public class StudentController {

	private static List<Student> bdStudents = new ArrayList<>(
			Arrays.asList(new Student(1L, "Ramiro", 1, "Ramiro.pedrozo@gmail.com"),
					new Student(2L, "Romario", 2, "Romario.pedrozo@gmail.com"),
					new Student(3L, "Roberto Carlos", 3, "Roberto.pedrozo@gmail.com"),
					new Student(4L, "Rivalvdo", 3, "Rivalvdo.pedrozo@gmail.com")));


	@ApiOperation(value = "Recurso responsavél por prover todos os estudantes ", tags = "Estudantes")
	@GetMapping
	public Iterable<Resource<Student>> findAll() {
		return bdStudents.stream().map(this::toResource).collect(Collectors.toList());
	}

	@ApiOperation(value = "Recurso responsavél por prover 1 estudante baseado em seu ID", tags = "Estudantes")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Resource<Student> findOne(@PathVariable Long id) {
		return bdStudents.stream().filter(t -> t.getIndentificator() == id).map(this::toResource).findAny().get();
	}


	@ApiOperation(value = "Recurso responsavél criar 1 estudante ", tags = "Estudantes")
	@PostMapping
	public Resource<Student> create(@RequestBody Student student) {
		bdStudents.add(student);
		return toResource(student);
	}


	@ApiOperation(value = "Recurso responsavél atualizar 1 estudante ", tags = "Estudantes")
	@PutMapping
	public Resource<Student> update(@RequestBody Student student) {
		bdStudents.removeIf(t -> t.getIndentificator().equals(student.getIndentificator()));
		bdStudents.add(student);
		return toResource(student);
	}


	@ApiOperation(value = "Recurso responsavél remover 1 estudante ", tags = "Estudantes")
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		bdStudents.removeIf(t -> t.getIndentificator().equals(id));
	}

	
	private Resource<Student> toResource(Student student) {
		return new Resource<>(student,
				linkTo(methodOn(StudentController.class).findOne(student.getIndentificator())).withSelfRel(),
				linkTo(methodOn(StudentController.class).findAll()).withRel("students"));
	}
}
