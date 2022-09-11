package com.simplilearn.foodbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.foodbox.repo.ProductRepo;
import com.simplilearn.foodbox.entity.ProductEntity;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepo repo;
	
	public ProductEntity addOrUpdate(ProductEntity prod) {
		return repo.save(prod);
	}
	
	public boolean deleteByTd(int pid) {
		repo.deleteById(pid);
		return true;
	}
	
	public List<ProductEntity> getAll(){
		return repo.findAll();
	}
	
	public ProductEntity getById(int pid) {
		return repo.findById(pid).get();
		
	}
	
	
	

}
