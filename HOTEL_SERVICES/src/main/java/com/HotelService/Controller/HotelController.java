package com.HotelService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HotelService.Services.HotelServices;
import com.HotelService.entity.Hotel;

@Controller
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelServices hotelservice;
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelservice.create(hotel));
	}
	
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> createHotel(@PathVariable String hotelId)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelservice.get(hotelId));
	}
	
	@GetMapping
	public ResponseEntity <List<Hotel>> getAll()
	{
		return ResponseEntity.ok(hotelservice.getAll());
	}
}
