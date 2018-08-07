package br.com.uni7.tcc.spring.springmvc;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.uni7.tcc.spring.springmvc.entity.User;
import br.com.uni7.tcc.spring.springmvc.repository.UserRepository;

@SpringBootApplication
public class SpringmvcApplication {

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(){
		return args -> {
			 
			userRepository.deleteAll();
 
			Random generator = new Random();
			for (int i = 1; i <= 1000; i++) {
				User user= new User("User"+i, generator.nextInt(80));
				userRepository.save(user);
			}
			
		};
	}
}
