package com.example.restcontrollerdemo.service;

import com.example.restcontrollerdemo.exception.type.NotFoundException;
import com.example.restcontrollerdemo.models.entities.User;
import com.example.restcontrollerdemo.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    public User findUserByFinCode(String finCode){
        return userRepo.findByFinCode(finCode).orElseThrow(() -> new NullPointerException("bele bir data yoxdur"));
    }
}
