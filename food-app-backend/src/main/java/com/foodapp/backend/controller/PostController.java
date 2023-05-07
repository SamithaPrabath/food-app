package com.foodapp.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.backend.model.Post;
import com.foodapp.backend.service.PostService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080" },allowedHeaders = "*")
public class PostController {
	@Autowired
	private PostService postService;
	
	@PostMapping("/addPost")
	public String addPost(@RequestBody Post post) {
		return postService.addPost(post);
		
	}
	
	@GetMapping("/getPosts")
	public List<Post> getPosts(){
		return postService.getPosts();
	}
	
	@GetMapping("/getSingleUserPosts/{userID}")
	public List<Post> getSingleUserPosts(@PathVariable String userID){
		return postService.getSingleUserPosts(userID);
	}
	
	@PutMapping("/editPost")
	public String updatePost(@RequestBody Post post){
		return postService.updatePost(post);
	}
	
	@DeleteMapping("/deletePost/{id}")
	public String deletePost(@PathVariable String id){
		return postService.deletePost(id);
	}
	
}
