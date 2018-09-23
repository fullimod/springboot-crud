package com.example.springboot.crud.controller;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@Override
	@PostMapping()
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
	
	@Override
	@PutMapping("/{user-id}")
    public User modifyUser(@RequestBody User user, @PathVariable("user-id") Integer userId) {
        return userService.modifyUser(user, userId);
    }
	
	@Override
	@GetMapping("/{user-id}")
    public User getUser(@PathVariable("user-id") Integer userId) {
        return userService.getUser(userId);
    }
	
	@Override
	@GetMapping()
	public List<User> listUser() {
        return userService.listUser();
    }

	@Override
	@DeleteMapping("/{user-id}")
	public Response deleteUser(@PathVariable("user-id") Integer userId) {
		userService.deleteUser(userId);
		return null;
	}
	
	

}
