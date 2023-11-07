package com.example.parctical3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parctical3.dto.UserDTO;
import com.example.parctical3.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/register")
	public String userRegister(@RequestBody UserDTO userDTO) {
		String received=userService.createUser(userDTO);
		return received;
		
	}
	@PostMapping("/login")
	public String userLogin(@RequestBody UserDTO userDTO)
	{
		String received=userService.loginUser(userDTO);
		return received;
		
	}

}
