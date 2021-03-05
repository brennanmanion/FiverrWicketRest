package com.mycompany.services;

import java.util.List;

import com.mycompany.pojo.User;

public interface IUserService {
	List<User> findAll();
	void save(final User user);	
}
