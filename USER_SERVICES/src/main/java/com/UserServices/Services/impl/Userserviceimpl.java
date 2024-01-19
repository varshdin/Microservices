package com.UserServices.Services.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.UserServices.Services.UserService;
import com.UserServices.entity.Hotel;
import com.UserServices.entity.Rating;
import com.UserServices.entity.User;
import com.UserServices.external.HotelService;
import com.UserServices.repository.UserRepository;

@Service
public class Userserviceimpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	

	private HotelService hotelService;
	
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
//		
		 Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);
	        //logger.info("{} ", ratingsOfUser);
	        List<Rating> ratings = Arrays.asList(ratingsOfUser);
	        List<Rating> ratingList = ratings.stream().map(rating -> {
	            //api call to hotel service to get the hotel
	            //http://localhost:8082/hotels/1cbaf36d-0b28-4173-b5ea-f1cb0bc0a791
	            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
	            Hotel hotel = hotelService.getHotel(rating.getHotelId());
	            logger.info("response status code: {} ",forEntity.getStatusCode());
	            //set the hotel to rating
	            rating.setHotel(hotel);
	            //return the rating
	            return rating;
	        }).collect(Collectors.toList());

//	        user.setRatings(ratingList);
	        return null;
	}
	
	
	
}
