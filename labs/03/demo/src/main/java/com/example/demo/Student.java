package com.example.demo;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Student {
	private Long indentificator;
	private String nome;
	private Integer matricula;
	private String email;
}


