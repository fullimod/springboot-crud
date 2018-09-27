package com.example.springboot.crud.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.example.springboot.crud.dto.User;
import com.example.springboot.crud.dto.UserDAO;

@Component()
public class UserMapper {
	
	Logger log = LogManager.getLogger(UserMapper.class);
	
	public UserDAO mapUserToDao(User user) {
		UserDAO dao = null;
		log.debug(user);
		
		if (null != user) {
			dao = new UserDAO();
			dao.setName(user.getName());
			dao.setAddress(user.getAddress());
			dao.setMail(user.getMail());
			dao.setPhone(user.getPhone());
		}
		
		log.debug(dao);
		return dao;
	}
	
	public User mapDaoToUser(UserDAO dao) {
		User user = null;
		log.debug(dao);
		
		if (null != dao) {
			user = new User();
			user.setId(dao.getId());
			user.setName(dao.getName());
			user.setAddress(dao.getAddress());
			user.setMail(dao.getMail());
			user.setPhone(dao.getPhone());
		}
		
		log.debug(user);
		return user;		
	}
	
	public List<User> mapDaosToUsers(List<UserDAO> daos) {
		List<User> users = null;
		
		if (null != daos && !daos.isEmpty()) {
			users = new ArrayList<User>();
			
			for (UserDAO dao : daos) {
				User user = mapDaoToUser(dao);
				users.add(user);
			}
		}
		
		return users;		
	}
	
}
