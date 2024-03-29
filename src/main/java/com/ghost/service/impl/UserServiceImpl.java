package com.ghost.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ghost.entity.dto.UserDto;
import com.ghost.service.UserService;
import com.ghost.service.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	private final UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDao.getUserByUsername(username);
	}

	@Override
	public int signup(UserDto user) {
		// TODO Auto-generated method stub
		return userDao.insertUser(user);
	}

}
