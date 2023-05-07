package com.foodapp.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.backend.model.Like;
import com.foodapp.backend.service.LikeService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080" },allowedHeaders = "*")
public class LikeController {
	@Autowired
	private LikeService likeService;
	
	@GetMapping("/getLikes/{postID}")
	public int getLikes(@PathVariable String postID){
		return likeService.getLikes(postID).size();
	}
	
	@PostMapping("/addLike")
	public String addLike(@RequestBody Like like) {
		return likeService.addLike(like);
	}
	
	@DeleteMapping("/removeLike/{userId}/{postId}")
	public String removeLike(@PathVariable String userId, @PathVariable String postId) {
		return likeService.removeLike(userId,postId);
	}
	
	@GetMapping("/getUserLike/{postId}/{userId}")
	public List<Like> findByPostIdAndUserId(@PathVariable String postId,@PathVariable String userId){
		return likeService.findByPostIdAndUserId(postId, userId);
	}

}
