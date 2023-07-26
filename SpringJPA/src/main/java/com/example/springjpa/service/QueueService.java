package com.example.springjpa.service;

import com.example.springjpa.models.Queue;
import com.example.springjpa.repo.QueueRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueueService {
    private final QueueRepo queueRepo;
    public Queue saveQueue(Queue queue){
        return  queueRepo.save(queue);
    }
}
