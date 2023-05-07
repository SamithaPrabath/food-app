package com.foodapp.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.foodapp.backend.model.Like;
import com.foodapp.backend.repositoreis.LikeRepo;

@Service
public class LikeService {
	@Autowired
	private LikeRepo likeRepo;
	
	private final MongoTemplate mongoTemplate;

    public LikeService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
	
	public List<Like> getLikes(String postID) {
		return likeRepo.findByPostId(postID);
	}
	
	public String addLike(Like like) {
		likeRepo.save(like);
		return like.getId();
	}
	
	public String removeLike(String userId, String postId) {
		Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        query.addCriteria(Criteria.where("postId").is(postId));
        mongoTemplate.remove(query, Like.class);
        
        return "remove Like";
	}
	
	public void removeLikeByPostID(String postId) {
		Query query = new Query();
        query.addCriteria(Criteria.where("postId").is(postId));
        mongoTemplate.remove(query, Like.class);
        
	}
	
	public void removeLikeByUserID(String userId) {
		Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        mongoTemplate.remove(query, Like.class);
        
	}
	
	public List<Like> findByPostIdAndUserId(String postId,String userId){
		Query query = new Query();
        query.addCriteria(Criteria.where("postId").is(postId));
        query.addCriteria(Criteria.where("userId").is(userId));

        List<Like> results = mongoTemplate.find(query, Like.class);
        return results;
	}
}
