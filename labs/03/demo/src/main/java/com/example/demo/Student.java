package com.example.demo;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Student extends ResourceSupport {
	private Long indentificator;
	private String nome;
	private Integer matricula;
	private String email;
}


