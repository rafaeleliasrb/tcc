package br.com.uni7.tcc.spring.springwebflux.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NonNull;

@Data
@Document(collection = "Users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@NonNull private String name;
	@NonNull private Integer age;

}
