package com.saf_saicoop.service;

import java.util.List;

import com.saf_saicoop.entity.User;



public interface IUserService {
   
	public List<User>findAll();	
	public void save(User user);	
	public User findById(Integer id);
}
