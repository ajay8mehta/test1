package com.application.springboot.mongodb;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;


public interface DBRepository extends Repository<User,String> {

	User save(User user);

	Optional<User> findOne(String id);

	List<User> findAll();
	void delete(User deleted);

}
