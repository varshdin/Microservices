package com.RatingServices.Service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RatingServices.Service.RatingService;
import com.RatingServices.entity.Rating;
import com.RatingServices.repository.RatingRepository;

@Service
public class Ratingserviceimpl implements RatingService {

	@Autowired
	private RatingRepository ratingrepository;
	
	@Override
	public Rating create(Rating rating) {
		String randomUserId = UUID.randomUUID().toString();
		rating.setRatingId(randomUserId);
		return ratingrepository.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		// TODO Auto-generated method stub
		return ratingrepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingrepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingrepository.findByHotelId(hotelId);
	}

}
