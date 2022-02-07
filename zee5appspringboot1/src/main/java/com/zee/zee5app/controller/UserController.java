package com.zee.zee5app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.service.UserService;

@RestController //@response body + @controller 
//rest api: resposne where we have to share the response 
//@responsebody
//CONTROLLER WILL THROW THE EXCEPTION TO SPRING AND IT WILL HANDLE IT
//
@RequestMapping("/users")
public class UserController
{
	//all the main method work can be done here
	@Autowired
	UserService userService;
	  
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody Register register)
	{
		try {
		Register result= userService.addUser(register);
		return ResponseEntity.status(201).body(result);
		
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			Map<String,String>hashMap=new HashMap<>();
			hashMap.put("message","record already exists");
			
			return ResponseEntity.badRequest().body(hashMap);
		}    
	}
	
	@GetMapping
	public ResponseEntity<?> getUserById(@PathVariable("id") String id) throws IdNotFoundException, InvalidIdLengthException, InvalidEmailException, InvalidPasswordException, InvalidNameException
	{
		userService.getUserById(id);
		return ResponseEntity.ok(id);
	}
	
	

}
