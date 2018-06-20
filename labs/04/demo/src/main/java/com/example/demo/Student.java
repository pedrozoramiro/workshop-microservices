package com.example.demo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@Entity
public class Student {
	
	 @Id @GeneratedValue(strategy = GenerationType.AUTO)
	  Long id;
	  String nome;
	  Integer matricula;
	  String email;
	  LocalDate dataNascimento;
}


