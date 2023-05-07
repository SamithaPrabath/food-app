package com.foodapp.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.foodapp.backend.model.Comment;
import com.foodapp.backend.repositoreis.CommentRepo;

@Service
public class CommentService {
	@Autowired
	private CommentRepo commentRepo;
	
	private final MongoTemplate mongoTemplate;

    public CommentService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

	public List<Comment> getComments() {
		return commentRepo.findAll();
	}
	
	
	public String addComment(Comment comment) {
		commentRepo.save(comment);
		return comment.getId();
	}
	
    public List<Comment> getComments(String postId) {
        return commentRepo.findByPostID(postId);
    }
    
    public String updateComment(Comment comment) {
    	 Query query = new Query();
         query.addCriteria(Criteria.where("id").is(comment.getId()));
         Update update = new Update();
         update.set("message", comment.getMessage());
         update.set("time", comment.getTime());
         mongoTemplate.updateFirst(query, update, Comment.class);
    	
    	return comment.getId();
    }
    
    public String deleteComment(String id) {
    	Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Comment.class);
        
        return "deleted comment";
    }
    
    public void deleteCommentByPostID(String postId) {
    	Query query = new Query();
        query.addCriteria(Criteria.where("postID").is(postId));
        mongoTemplate.remove(query, Comment.class);
        
    }
    public void deleteCommentByUserID(String userId) {
    	Query query = new Query();
        query.addCriteria(Criteria.where("user_name").is(userId));
        mongoTemplate.remove(query, Comment.class);
        
    }
	
}

