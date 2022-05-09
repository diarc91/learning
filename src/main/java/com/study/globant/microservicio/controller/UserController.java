package com.study.globant.microservicio.controller;

import java.lang.management.MemoryType;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.study.globant.microservicio.model.User;
import com.study.globant.microservicio.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public List<User> getAllUsers(){
		
		return this.userService.getAll();
		
	}	
	
	@PostMapping()
	public void save(@Validated @RequestBody User user) throws Exception{
		
		this.userService.save(user);
		
	}

}
