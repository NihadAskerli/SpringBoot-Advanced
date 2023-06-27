package com.example.springjpa.service;

import com.example.springjpa.models.User;
import com.example.springjpa.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    public User getUserByName(String name){
        return userRepo.getUserByName(name);
    }
    public User saveUser(User user){
        return userRepo.save(user);
    }
    public List<User> findAllUser(){
        return userRepo.findAll();
    }
}
