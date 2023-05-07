package com.foodapp.backend.repositoreis;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.foodapp.backend.model.Post;

public interface PostRepo extends MongoRepository<Post,String>{
	@Query("{'userID':?0}")
	List<Post> findByUserID(String userID);
}
