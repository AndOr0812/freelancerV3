package com.freelancer.server.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelancer.server.exception.ResourceNotFoundException;
import com.freelancer.server.model.User;
import com.freelancer.server.repository.UserRepository;
import com.freelancer.server.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository UserRepository;
	
    @CrossOrigin
	@GetMapping("/")
	public String getUser() {
		return "This is the User Route";
	}
    
    @CrossOrigin
	@PostMapping("/signup")
	public User createUser(@Valid @RequestBody User user) {
		try {
			//If Successful signup then return the created User data
		return UserRepository.save(user);
		}catch(Exception e) {
			//Failing to Signup
			return null;
		}
	}
    
    @CrossOrigin
	@PostMapping(path="/login",consumes = MediaType.APPLICATION_JSON_VALUE)
	public User login(@RequestBody String userCred) throws JSONException {
		JSONObject jsonobject = null;
		User userList = null;
		try{
			jsonobject = new JSONObject(userCred);
			System.out.println("username is ");
			System.out.println(jsonobject.getString("username"));
			System.out.println("password is ");
			System.out.println(jsonobject.getString("password"));

			//Check whether emailId exists
			userList = UserRepository.findByEmail(jsonobject.getString("username"));
			System.out.println(userList.getPassword());
			
			//Check whether password is matching
			if(jsonobject.getString("password").equals(userList.getPassword())) {
				System.out.println("Password matched");
				return userList;
			}
			else {
				System.out.println("Password didn't matched");
				return null;
			}
		}catch(Exception e) {
			return null;
		}
        
	}
}
