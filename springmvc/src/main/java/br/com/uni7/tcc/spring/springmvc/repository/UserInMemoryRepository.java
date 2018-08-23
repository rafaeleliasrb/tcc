package br.com.uni7.tcc.spring.springmvc.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.uni7.tcc.spring.springmvc.entity.User;

@Repository
public class UserInMemoryRepository {

	private List<User> users = new ArrayList<>();
	
	public void save(User user) {
		if(users.stream().anyMatch(u -> u.getId().equals(user.getId()))) {
			throw new RuntimeException("User already added");
		}
		users.add(user);
	}
	
	public List<User> findAll(long responseDelay) {
		try {
			Thread.sleep(responseDelay);
		} catch (InterruptedException e) {}
		return Collections.unmodifiableList(users);
	}
}
