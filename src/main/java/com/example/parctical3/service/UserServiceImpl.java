package com.example.parctical3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parctical3.dto.UserDTO;
import com.example.parctical3.entity.User;
import com.example.parctical3.repository.UserRepository;
import com.example.parctical3.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public String createUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		userRepository.save(user);
		return "User "+userDTO.getEmail()+" created";
	}
	@Override
	public String loginUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		Optional<User> optional=userRepository.findById(userDTO.getEmail());
		User user=optional.get();
		if(user.getPassword().equals(userDTO.getPassword()))
		{
			return "User Logged In Successfully";
		}
		else
		{
			return "Login failed!!! Please Check Your Password";
		}
	}
	

}
