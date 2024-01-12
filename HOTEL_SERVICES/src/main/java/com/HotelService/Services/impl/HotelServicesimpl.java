package com.HotelService.Services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelService.Repository.HotelRepository;
import com.HotelService.Services.HotelServices;
import com.HotelService.entity.Hotel;

@Service
public class HotelServicesimpl implements HotelServices {

	@Autowired
	private HotelRepository hotelRepository;
	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		String hotelId=UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
		}

	@Override
	public Hotel get(String id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id).orElse(null);
	}

}
