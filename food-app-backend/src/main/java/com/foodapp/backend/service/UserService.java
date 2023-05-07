package com.foodapp.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.foodapp.backend.model.User;
import com.foodapp.backend.repositoreis.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private LikeService likeService;
	
	@Autowired 
	private PostService postService;
	
	@Autowired
	private RatingService ratingService;
	
	private final MongoTemplate mongoTemplate;

    public UserService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
	
    public String addUser(User user) {
		userRepo.save(user);
		return user.getId();
	}
	
    public List<User> getUserDetails(String userName) {
		return userRepo.findByUserName(userName);
	}
	
	public String updateUser(User user) {
		Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(user.getUserName()));
        Update update = new Update();
        update.set("password", user.getPassword());
        update.set("address", user.getAddress());
        update.set("fName", user.getfName());
        update.set("lName", user.getlName());
        update.set("dob", user.getDob());
        mongoTemplate.updateFirst(query, update, User.class);
   	
        return user.getId();
	}
	
	public String deleteUser(String userName) {
    	Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(userName));
        mongoTemplate.remove(query, User.class);
        
        commentService.deleteCommentByUserID(userName);
        likeService.removeLikeByUserID(userName);
        postService.deletePostByUserId(userName);
        ratingService.deleteRatingByUSerId(userName);
        return "deleted user";
    }
	
	

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
