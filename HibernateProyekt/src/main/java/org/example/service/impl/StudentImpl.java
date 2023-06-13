package org.example.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.models.Student;
import org.example.config.AbstractDAO;
import org.example.service.inter.StudentInter;

import java.security.cert.CRLReason;


public class StudentImpl extends AbstractDAO implements StudentInter {
    public Student getByName(String name) {
        EntityManager entityManager = em();
        entityManager.getTransaction().begin();
        TypedQuery<Student> query=entityManager.createQuery("select s from Student s where s.studetnName=?1", Student.class);
//TypedQuery<Student> studentTypedQuery=entityManager.createNamedQuery("select s from Student s where s.studetnName=?1", Student.class)
        Student student=query.setParameter(1,name).getSingleResult();
CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
criteriaBuilder.

//        entityManager.persist(new Student(null,"Ayten"));
//      entityManager.createNamedQuery("name");
        entityManager.getTransaction().commit();
        entityManager.close();
        return student;

    }

}
