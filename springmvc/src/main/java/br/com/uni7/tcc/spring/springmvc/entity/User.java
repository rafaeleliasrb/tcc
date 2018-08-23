package br.com.uni7.tcc.spring.springmvc.entity;

import java.io.Serializable;

import lombok.Data;

@Data
/*@Entity(name="Users")*/
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)*/
	private Long id;
	private String name;
	private Integer age;

}
