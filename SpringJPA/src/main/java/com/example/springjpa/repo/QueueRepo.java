package com.example.springjpa.repo;

import com.example.springjpa.models.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QueueRepo extends JpaRepository<Queue,Long> {
    @Query()
    List<Queue> getName();
}
