package com.project.product.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.product.repository.UserRepository;
import com.project.product.security.JWTUserDetails;
import com.project.product.entity.User;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    } 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        return JWTUserDetails.create(user);
    }
    
    public UserDetails loadUserById(Long id){
        User user = userRepository.findById(id).get();
        return JWTUserDetails.create(user);
    }
}
