package com.example.springjpa.repo;

import com.example.springjpa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {
    User getUserByName(String name);
    User getDistinctByUsername(String username);
    List<User> getAllByCityAfterAndSurname(String city, String surname);
}
