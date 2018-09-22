package com.example.springboot.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.crud.dto.User;
import com.example.springboot.crud.service.UserService;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping()
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

}
