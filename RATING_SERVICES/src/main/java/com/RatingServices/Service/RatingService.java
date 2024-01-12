package com.RatingServices.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RatingServices.entity.Rating;

@Service
public interface RatingService {

	Rating create(Rating rating);
	
	List<Rating> getRatings();
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);
	
}
