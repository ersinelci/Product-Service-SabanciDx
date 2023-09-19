package com.project.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.product.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
    User findByUserName(String userName);
}