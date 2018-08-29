package br.com.uni7.tcc.spring.springwebflux.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Integer age;

}
