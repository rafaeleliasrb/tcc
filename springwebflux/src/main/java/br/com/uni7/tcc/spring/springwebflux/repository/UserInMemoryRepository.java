package br.com.uni7.tcc.spring.springwebflux.repository;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uni7.tcc.spring.springwebflux.entity.User;
import reactor.core.publisher.Flux;

@Repository
public class UserInMemoryRepository {

	private List<User> users = new ArrayList<>();
	
	public void save(User user) {
		if(users.stream().anyMatch(u -> u.getId().equals(user.getId()))) {
			throw new RuntimeException("User already added");
		}
		users.add(user);
	}
	
	public Flux<User> findAll(long responseDelay) {
		return Flux.fromIterable(users)
				.delaySubscription(Duration.ofMillis(responseDelay));
	}
}
