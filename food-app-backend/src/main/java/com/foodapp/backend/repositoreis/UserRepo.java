package com.foodapp.backend.repositoreis;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodapp.backend.model.User;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
	//Optional<User> findByUserName1(String userName);
	@Query("{'userName':?0}")
	List<User> findByUserName(String userName);
}
