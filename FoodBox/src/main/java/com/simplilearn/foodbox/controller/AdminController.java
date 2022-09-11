package com.simplilearn.foodbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.foodbox.entity.AdminEntity;
import com.simplilearn.foodbox.service.AdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@PostMapping("/")
	public ResponseEntity<Object> addAdminEntity(@RequestBody AdminEntity admin){
		
		AdminEntity data= service.addAdmin(admin);
		if(data!=null)
			return new ResponseEntity<Object>(data,HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Error while adding Admin", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/")
	public List<AdminEntity> getAllAdmins(){
		return service.getAllAdmins();
	}
	
	@PutMapping("/{aid}")
	public ResponseEntity<Object> updateAdminEntity(@RequestBody AdminEntity admin,@PathVariable int aid){
		AdminEntity data= service.updateAdmin(admin, aid);
		if(data!=null)
		return new ResponseEntity<Object>(data,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Admin is not available for update",
					HttpStatus.NOT_FOUND);
	}

}
