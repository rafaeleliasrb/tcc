package br.com.uni7.tcc.spring.springwebflux;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.uni7.tcc.spring.springwebflux.entity.User;
import br.com.uni7.tcc.spring.springwebflux.repository.UserInMemoryRepository;

@SpringBootApplication
public class SpringwebfluxApplication {

	/*@Autowired
	private UserRepository userRepository;*/
	
	@Autowired
	private UserInMemoryRepository userInMemoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringwebfluxApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
 
			//Mono<Void> deleteAll = userRepository.deleteAll();
 
			/*deleteAll.subscribe(e -> {
 
			}, Throwable::printStackTrace);*/
 
			Random generator = new Random();
			for (int i = 1; i <= 1000; i++) {
				User user= new User();
				user.setId(Long.valueOf(i));
				user.setName("User"+i);
				user.setAge(generator.nextInt(80));
				
				userInMemoryRepository.save(user);
				/*Mono<User> data = userRepository.insert(user);
 
				data.subscribe(e -> {}
						, Throwable::printStackTrace);*/
			}
		};
	}	
}
