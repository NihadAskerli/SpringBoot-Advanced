package com.example.springjpa;

import com.example.springjpa.models.Role;
import com.example.springjpa.models.User;
import com.example.springjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor

public class SpringJpaApplication implements CommandLineRunner {
    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        List<Role> roleList = new ArrayList<>();
//        roleList.add(Role.USER);
//        roleList.add(Role.ADMIN);
//        userService.saveUser(new User(1l, "askerlinihad", "baki", "nihad", "esgerli", roleList));
        userService.findAllUser().forEach(System.out::println);
    }
}
