package br.com.uni7.tcc.spring.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.uni7.tcc.spring.springmvc.entity.User;
import br.com.uni7.tcc.spring.springmvc.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping
    public @ResponseBody Iterable<User> getAllUser() {
		return userRepository.findAll();
    }
	
}
