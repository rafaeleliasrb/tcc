package br.com.uni7.tcc.spring.springwebflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uni7.tcc.spring.springwebflux.entity.User;
import br.com.uni7.tcc.spring.springwebflux.repository.UserRepository;
import reactor.core.publisher.Flux;
 
@RestController
@RequestMapping("/users")
public class UserController {
 
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
    public Flux<User> getAllUser() {
        return userRepository.findAll();
    }

}
