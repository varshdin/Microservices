package com.HotelService.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HotelService.entity.Hotel;

@Service
public interface HotelServices  {

	Hotel create(Hotel hotel);
	
	List<Hotel> getAll();
	
	Hotel get(String id); 
	
}
