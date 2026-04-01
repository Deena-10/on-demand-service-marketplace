package com.app.user_application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.user_application.entity.User;
import com.app.user_application.repository.UserRepository;

@Service
public class UserService {

    

	
	@Autowired
	UserRepository userrepo;
//create
	public User createuser(User user) {
		return  userrepo.save(user);
	}
//list all users
	public List<User> getalluser() {		
		return userrepo.findAll();
	}
//find by id
	public User getbyuserid(Long id) {	
	    return userrepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found"));
	}
	//update
	public User updateuser(Long id, User updateuser) {
		User user1=getbyuserid(id);
		user1.setUsername(updateuser.getUsername());
		user1.setEmailid(updateuser.getEmailid());
		user1.setMobile_number(updateuser.getMobile_number());
		user1.setPassword(updateuser.getPassword());
		return userrepo.save(user1);
	}
//delete
	 public void deleteuser(Long id) {
	        userrepo.deleteById(id);
	    
	 }
	

	

	
}
