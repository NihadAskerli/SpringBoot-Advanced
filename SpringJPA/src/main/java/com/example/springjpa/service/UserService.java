package com.example.springjpa.service;

import com.example.springjpa.models.Queue;
import com.example.springjpa.models.User;
import com.example.springjpa.repo.UserRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLClientInfoException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final EntityManager entityManager;
    private final QueueService queueService;
    public User getUserByName(String name){
        return userRepo.getUserByName(name);
    }
//    @Transactional()
    public User saveUser(User user, Queue queue){
userRepo.
        queueService.saveQueue(queue);
        return userRepo.save(user);
    }
    public List<User> findAllUser(){
        return userRepo.findAll();
    }
    public void updateUser(User user){
        entityManager.getTransaction().begin();
        entityManager.merge(user);
       CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();

       CriteriaQuery<User>userCriteriaQuery=criteriaBuilder.createQuery(User.class);
        Root<User> userRoot=userCriteriaQuery.from(User.class);
       userCriteriaQuery.select(userRoot);
       CriteriaQuery<User>query=userCriteriaQuery.where(criteriaBuilder.equal(userRoot.get("name"),22));
    TypedQuery<User>userTypedQuery=entityManager.createQuery(query);
    userTypedQuery.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
