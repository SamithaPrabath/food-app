package com.foodapp.backend.repositoreis;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodapp.backend.model.Rating;

@Repository
public interface RatingRepo extends MongoRepository<Rating, String>{
	@Query("{'resturantName':?0}")
	List<Rating> findByresturantName(String resturantName);
}
