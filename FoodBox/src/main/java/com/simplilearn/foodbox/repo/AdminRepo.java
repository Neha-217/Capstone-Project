package com.simplilearn.foodbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.foodbox.entity.AdminEntity;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity, Integer> {

}
