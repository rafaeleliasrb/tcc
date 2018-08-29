package br.com.uni7.tcc.spring.springwebflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.uni7.tcc.spring.springwebflux.entity.User;
import br.com.uni7.tcc.spring.springwebflux.repository.UserInMemoryRepository;
import reactor.core.publisher.Flux;
 
@RestController
@RequestMapping("/users")
public class UserController {
 
	@Autowired
	private UserInMemoryRepository userInMemoryRepository;
	
	@GetMapping("/{delay}")
    public @ResponseBody Flux<User> getAllUserInMemory(@PathVariable long delay) {
		return userInMemoryRepository.findAll(delay);
    }
}
