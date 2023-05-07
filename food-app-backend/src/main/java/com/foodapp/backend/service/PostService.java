package com.foodapp.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.foodapp.backend.model.Post;
import com.foodapp.backend.repositoreis.PostRepo;

@Service
public class PostService {
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private LikeService likeService;
	
	private final MongoTemplate mongoTemplate;

    public PostService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
	
	public String addPost(Post post) {
		postRepo.save(post);
		return post.getId();
	}
	
	public List<Post> getPosts(){
		return postRepo.findAll();
	}
	
	public String deletePost(String id) {
    	Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Post.class);
        
        commentService.deleteCommentByPostID(id);
        likeService.removeLikeByPostID(id);
        return "deleted Post";
    }
	
	public void deletePostByUserId(String userId) {
    	Query query = new Query();
        query.addCriteria(Criteria.where("userID").is(userId));
        mongoTemplate.remove(query, Post.class);
        
    }
	
	public String updatePost(Post post) {
   	 	Query query = new Query();
        query.addCriteria(Criteria.where("id").is(post.getId()));
        Update update = new Update();
        update.set("resturantName", post.getResturantName());
        update.set("description", post.getDescription());
        update.set("image", post.getImage());
        update.set("time", post.getTime());
        mongoTemplate.updateFirst(query, update, Post.class);
   	
        return post.getId();
   
	}
	
	public List<Post> getSingleUserPosts(String userId){
		return postRepo.findByUserID(userId);
	}
	
	

}
