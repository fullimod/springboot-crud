package com.example.springboot.crud.mapper;

import org.springframework.stereotype.Component;

import com.example.springboot.crud.dto.User;
import com.example.springboot.crud.dto.UserDAO;

@Component()
public class UserMapper {
	
	public UserDAO mapUserToDao(User user) {
		UserDAO dao = null;
		
		if (null != user) {
			dao = new UserDAO();
			dao.setName(user.getName());
			dao.setAddress(user.getAddress());
			dao.setMail(user.getMail());
			dao.setPhone(user.getPhone());
		}
		
		return dao;
	}
	
	public User mapDaoToUser(UserDAO dao) {
		User user = null;
		
		if (null != dao) {
			user = new User();
			user.setId(dao.getId());
			user.setName(dao.getName());
			user.setAddress(dao.getAddress());
			user.setMail(dao.getMail());
			user.setPhone(dao.getPhone());
		}
		
		return user;		
	}
	
}
