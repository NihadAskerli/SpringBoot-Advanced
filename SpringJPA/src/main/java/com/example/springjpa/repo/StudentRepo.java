package com.example.springjpa.repo;

import com.example.springjpa.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student,Long> {

    Optional<Student> findStudentByName(String name);
}
