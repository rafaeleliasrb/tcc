package br.com.uni7.tcc.spring.springwebflux.repository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.com.uni7.tcc.spring.springwebflux.entity.User;
 
public interface UserRepository extends ReactiveMongoRepository<User, Integer> {
 
}
