package com.foodapp.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.backend.model.Rating;
import com.foodapp.backend.service.RatingService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080" },allowedHeaders = "*")
public class RatingsController {
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/addRating")
	public String addRating(@RequestBody Rating rating) {
		return ratingService.addRating(rating);
	}
	
	@GetMapping("/getRatings/{resturantName}")
	public List<Rating> getRatings(@PathVariable String resturantName){
		return ratingService.getRatings(resturantName);
	}
	
	@PutMapping("/updateRating")
	public String updateRating(@RequestBody Rating rating) {
		return ratingService.updateRating(rating);
	}
	
	@DeleteMapping("/deleteRating/{id}")
	public  String deleterating(@PathVariable String id) {
		return ratingService.deleterating(id);
	}
}
