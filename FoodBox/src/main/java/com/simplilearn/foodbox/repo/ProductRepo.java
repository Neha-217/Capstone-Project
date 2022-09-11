package com.simplilearn.foodbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.foodbox.entity.ProductEntity;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

}
