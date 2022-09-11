package com.simplilearn.foodbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.foodbox.entity.UserEntity;
import com.simplilearn.foodbox.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/")
	public ResponseEntity<Object> addUserEntity(@RequestBody UserEntity user){
		UserEntity data = service.addUser(user);
		if(data!=null)
			return new ResponseEntity<Object>(data, HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Error while adding User", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/")
	public List<UserEntity> getAllUsers(){
		return service.getAllUsers();
	}
	
	@GetMapping("/{uid}")
	public ResponseEntity<Object> getUserById(@PathVariable int uid){
		if(service.getUserById(uid)!=null)
			return new ResponseEntity<Object>(service.getUserById(uid),HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("User is not available with given id",
					HttpStatus.NOT_FOUND);
		
	}

}

	
	

