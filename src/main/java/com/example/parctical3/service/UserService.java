package com.example.parctical3.service;

import com.example.parctical3.dto.UserDTO;

public interface UserService {
	
	public String createUser(UserDTO userDTO);

	public String loginUser(UserDTO userDTO);

}
