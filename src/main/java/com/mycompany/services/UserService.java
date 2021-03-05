package com.mycompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.dao.IUserDao;
import com.mycompany.pojo.User;

@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    private IUserDao userDao;	
	
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

}
