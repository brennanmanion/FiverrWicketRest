package com.mycompany.dao;

import java.util.List;

import com.mycompany.pojo.User;

public interface IUserDao extends IGenericDao<User>{
	List<User> findAll();
}
