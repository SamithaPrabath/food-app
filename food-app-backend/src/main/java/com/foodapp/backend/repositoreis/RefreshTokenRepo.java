package com.foodapp.backend.repositoreis;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.foodapp.backend.model.RefreshToken;

public interface RefreshTokenRepo extends MongoRepository<RefreshToken, String> {

}
