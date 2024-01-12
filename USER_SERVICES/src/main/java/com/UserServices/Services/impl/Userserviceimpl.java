package com.UserServices.Services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserServices.Services.UserService;
import com.UserServices.entity.User;
import com.UserServices.repository.UserRepository;

@Service
public class Userserviceimpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		 User user = userRepository.findById(userId).orElse(null);
		 return user;
	}
	
	
	
}
