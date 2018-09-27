package com.example.springboot.crud.controller;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	Logger log = LogManager.getLogger(UserControllerImpl.class);
	
	@Autowired
	private UserService userService;
	
	@Override
	@PostMapping()
    public User createUser(@RequestBody User user) {
		log.info("-- ENTRADA -- Alta de usuario");
		User output = userService.createUser(user);
		
		log.info("-- SALIDA -- Alta de usuario");
        return output;
    }
	
	@Override
	@PutMapping("/{user-id}")
    public User modifyUser(@RequestBody User user, @PathVariable("user-id") Integer userId) {
		log.info("-- ENTRADA -- Modificación de usuario");
		User output = userService.modifyUser(user, userId);
		
		log.info("-- SALIDA -- Modificación de usuario");
        return output;
    }
	
	@Override
	@GetMapping("/{user-id}")
    public User getUser(@PathVariable("user-id") Integer userId) {
		log.info("-- ENTRADA -- Detalle de usuario");
		User user = userService.getUser(userId);
		
		log.info("-- SALIDA -- Detalle de usuario");
        return user;
    }
	
	@Override
	@GetMapping()
	public List<User> listUser() {
		log.info("-- ENTRADA -- Listado de usuarios");
		List<User> users = userService.listUser();
		
		log.info("-- SALIDA -- Listado de usuarios");
        return users;
    }

	@Override
	@DeleteMapping("/{user-id}")
	public Response deleteUser(@PathVariable("user-id") Integer userId) {
		log.info("-- ENTRADA -- Baja de usuario");		
		userService.deleteUser(userId);
		
		log.info("-- SALIDA -- Baja de usuario");
		return null;
	}
	
	

}
