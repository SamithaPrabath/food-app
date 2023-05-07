package com.foodapp.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.foodapp.backend.model.Rating;
import com.foodapp.backend.repositoreis.RatingRepo;

@Service
public class RatingService {
	@Autowired
	private RatingRepo ratingRepo;
	
	private final MongoTemplate mongoTemplate;

    public RatingService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    
    public String addRating(Rating rating) {
    	ratingRepo.save(rating);
    	return rating.getId();
    }
    
    public List<Rating> getRatings(String resturantName){
    	Query query = new Query();
        query.addCriteria(Criteria.where("resturantName").is(resturantName));

        List<Rating> results = mongoTemplate.find(query, Rating.class);
        return results;
    }
    
    public String updateRating(Rating rating) {
    	Query query = new Query();
        query.addCriteria(Criteria.where("id").is(rating.getId()));
        Update update = new Update();
        update.set("message", rating.getMessage());
        update.set("time", rating.getTime());
        update.set("rate", rating.getRate());
        mongoTemplate.updateFirst(query, update, Rating.class);
   	
        return rating.getId();
    }
    
    public String deleterating(String id) {
    	Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Rating.class);
        
        return "deleted rating";
    }
    
    public void deleteRatingByUSerId(String userId) {
    	Query query = new Query();
        query.addCriteria(Criteria.where("userID").is(userId));
        mongoTemplate.remove(query, Rating.class);
        
    }
    
}
