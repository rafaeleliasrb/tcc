package br.com.uni7.tcc.spring.springwebflux.entity;

import java.io.Serializable;

import lombok.Data;

@Data
/*@Document(collection = "Users")*/
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/*@Id*/
	private Long id;
	private String name;
	private Integer age;

}
