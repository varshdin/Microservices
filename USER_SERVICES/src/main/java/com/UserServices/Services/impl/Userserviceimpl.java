package com.UserServices.Services.impl;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.UserServices.Services.UserService;
import com.UserServices.entity.User;
import com.UserServices.repository.UserRepository;

@Service
public class Userserviceimpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger= (Logger) LoggerFactory.getLogger(Userserviceimpl.class);

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
		 
		 //fetch rating
		
		 Rating[] ratingsOfUser = RestTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);
	}
	
	
	
}
