package com.freelancer.server.service;

import java.security.MessageDigest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelancer.server.model.User;
import com.freelancer.server.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	static
	UserRepository userrepository;
	
	public Iterable<User> getAllUsers(){
		return userrepository.findAll();
	}
	
	public void addUser(User user) {
		userrepository.save(user);
	}
	
	public static User login(String email,String password){
		System.out.println("passed email is "+email+" passed password is "+password);
		User fetched_user = userrepository.findByEmail(email);
		System.out.println("fetched user is "+fetched_user);
		if(fetched_user == null) {
			System.out.println("User Not FOund with the email provided");
			return fetched_user;
		}
		
		System.out.println("password is "+password);
		
		String hashed_password = generateHash(password);
		System.out.println("hashed password is "+hashed_password);
		return fetched_user;
	}
	
	public List<User> findByEmail(String email){
		return userrepository.findByEmail(email);
	}
	
	public static String generateHash(String input) {
        StringBuilder hash = new StringBuilder();

        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
        byte[] hashedBytes = sha.digest(input.getBytes());
        char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        for (int idx = 0; idx < hashedBytes.length;idx++) {
            byte b = hashedBytes[idx];
            hash.append(digits[(b & 0xf0) >> 4]);
            hash.append(digits[b & 0x0f]);
        }
        } catch (Exception e) {
        System.out.println("Error occured while hashing password");
        }
    return hash.toString();
	}
}
