package com.saf_saicoop.dao;
import org.springframework.data.repository.CrudRepository;

import com.saf_saicoop.entity.User;


public interface UserDao extends CrudRepository<User, Integer> {

	public User findUserByUsername(String username);
	
}
