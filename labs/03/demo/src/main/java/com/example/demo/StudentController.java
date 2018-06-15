package com.example.demo;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

	private static List<Student> bdStudents = new ArrayList<>(
			Arrays.asList(new Student(1L, "Ramiro", 1, "Ramiro.pedrozo@gmail.com"),
					new Student(2L, "Romario", 2, "Romario.pedrozo@gmail.com"),
					new Student(3L, "Roberto Carlos", 3, "Roberto.pedrozo@gmail.com"),
					new Student(4L, "Rivalvdo", 3, "Rivalvdo.pedrozo@gmail.com")));

	@GetMapping
	public Iterable<Student> list() {
		return bdStudents;
	}

	@GetMapping("{id}")
	//@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/xml")
	@ResponseBody
	public Student get(@PathVariable Long id) {
	        Student student = bdStudents.stream().filter(t -> t.getIndentificator() == id).findAny().get();
	        student.add( linkTo(StudentController.class).withSelfRel()); 
	       return student ;
	}

	@PostMapping
	public void create(@RequestBody Student student) {
		bdStudents.add(student);
	}

	@PutMapping
	public void update(@RequestBody Student student) {
		bdStudents.removeIf(t -> t.getIndentificator().equals(student.getIndentificator()));
		bdStudents.add(student);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		bdStudents.removeIf(t -> t.getIndentificator().equals(id));
	}

}
