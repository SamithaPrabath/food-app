package com.foodapp.backend.repositoreis;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodapp.backend.model.Like;

@Repository
public interface LikeRepo extends MongoRepository<Like, String>{
	@Query("{'postId':?0}")
	List<Like> findByPostId(String postId);
	
}
