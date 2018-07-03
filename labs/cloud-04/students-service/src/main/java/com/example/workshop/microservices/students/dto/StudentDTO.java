package com.example.workshop.microservices.students.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	
	  Long id;
	  String nome;
	  Integer matricula;
	  String email;
	  LocalDate dataNascimento;
	  List<String> disciplinas;
}


