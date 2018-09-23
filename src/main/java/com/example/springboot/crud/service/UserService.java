package com.example.springboot.crud.service;

import java.util.List;

import com.example.springboot.crud.dto.User;

public interface UserService {
	
	public User createUser(User user);
	public User modifyUser(User user, Integer userId);
	public User getUser(Integer userId);
	public List<User> listUser();
	public void deleteUser(Integer userId);

}
