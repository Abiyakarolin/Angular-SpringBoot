package com.wipro.DietManagement.config;

import org.springframework.data.repository.CrudRepository;

import com.wipro.DietManagement.model.User;

public interface UserRepo extends CrudRepository<User, Integer> {
	
	User findByEmail(String email);

}
