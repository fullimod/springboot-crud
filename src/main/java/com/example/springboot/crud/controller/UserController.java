package com.example.springboot.crud.controller;

import java.util.List;

import javax.ws.rs.core.Response;

import com.example.springboot.crud.dto.User;

public interface UserController {
	
	public User createUser(User user);
	public User modifyUser(User user, Integer userId);
	public User getUser(Integer userId);
	public List<User> listUser();
	public Response deleteUser(Integer userId);

}
