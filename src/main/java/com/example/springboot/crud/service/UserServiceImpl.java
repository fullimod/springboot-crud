package com.example.springboot.crud.service;

import java.util.List;

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

	@Override
	public User modifyUser(User user, Integer userId) {
		UserDAO dao = userRepository.getOne(userId);
		dao.setName(user.getName());
		dao.setAddress(user.getAddress());
		dao.setPhone(user.getPhone());
		dao.setMail(user.getMail());
			
		userRepository.save(dao);
		return userMapper.mapDaoToUser(dao);
	}

	@Override
	public User getUser(Integer userId) {
		UserDAO dao = userRepository.getOne(userId);
		return userMapper.mapDaoToUser(dao);
	}

	@Override
	public List<User> listUser() {
		List<UserDAO> daos = userRepository.findAll();		
		return userMapper.mapDaosToUsers(daos);
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}

}
