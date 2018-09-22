package com.example.springboot.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.crud.dto.User;
import com.example.springboot.crud.dto.UserDAO;
import com.example.springboot.crud.mapper.UserMapper;
import com.example.springboot.crud.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User createUser( User user) {
		UserDAO dao = userRepository.save(userMapper.mapUserToDao(user));
		return userMapper.mapDaoToUser(dao);
	}

}
