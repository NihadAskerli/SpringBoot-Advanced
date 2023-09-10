package com.example.restcontrollerdemo.repo;

import com.example.restcontrollerdemo.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByFinCode(String finCode);
}
