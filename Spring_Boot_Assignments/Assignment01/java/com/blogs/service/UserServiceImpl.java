package com.blogs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.dao.UserDao;
import com.blogs.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(String em, String pass) {
		return userDao.findByEmailAndPassword(em, pass).orElseThrow();
	}

	/*
	 * in case of valid - returns user to the caller
	 * invalid login -throws NoSuchElementException
	 */
	
	
	
	
}
