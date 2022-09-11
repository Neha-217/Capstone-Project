package com.simplilearn.foodbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.foodbox.entity.ProductEntity;
import com.simplilearn.foodbox.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/")
	private List<ProductEntity> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{pid}")
	private ProductEntity getById(@PathVariable int pid) {
		return service.getById(pid);
	}
	
	@PostMapping("/")
	private ProductEntity add(@RequestBody ProductEntity prod) {
		return service.addOrUpdate(prod);
	}
	@PutMapping("/{pid}")
	private ProductEntity update(@PathVariable int pid, @RequestBody ProductEntity prod) {
		prod.setPid(pid);
		return service.addOrUpdate(prod);
	}
	
	@DeleteMapping("/{pid}")
	private void delete(@PathVariable int pid) {
		service.deleteByTd(pid);
	}
	
}

	
	
	


