package br.com.uni7.tcc.spring.springmvc.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.uni7.tcc.spring.springmvc.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}