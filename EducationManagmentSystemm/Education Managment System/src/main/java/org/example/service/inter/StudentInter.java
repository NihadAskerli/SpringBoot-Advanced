package org.example.service.inter;

import org.example.models.Student;
public interface StudentInter {

    Student addStudent(Student student);

    Student deleteStudent(String finCode);

    Student getByName(String name);

    void deleteByName(String name);

   Student addStudentToTeacher(String name);

    }
