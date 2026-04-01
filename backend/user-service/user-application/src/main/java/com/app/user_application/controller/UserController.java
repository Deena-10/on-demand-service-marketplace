package com.app.user_application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.user_application.entity.User;
import com.app.user_application.service.UserService;

@RestController
@RequestMapping("/userservice")
public class UserController {

	@Autowired
	UserService userservice;
	
	//create(Add)
	@PostMapping("/user")
	public User createuser(@RequestBody User user) {
		return  userservice.createuser(user);
	}
	
	//list all users
	@GetMapping("/user")
	public List<User> getalluser(){
		return userservice.getalluser();
	}
	
    //get by id
	@GetMapping("/user")
	public User getuserbyid(@PathVariable Long id) {
		return userservice.getbyuserid(id);
	}
	
	//update
	@PutMapping("/user/{id}")
	public User updateuser( @PathVariable Long id,@RequestBody User user) {
		return userservice.updateuser(id,user);	
	}
	
	
	@DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userservice.deleteuser(id);
        return "User deleted successfully";
    }
}
