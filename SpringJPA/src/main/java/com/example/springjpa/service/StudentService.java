package com.example.springjpa.service;

import com.example.springjpa.models.Student;
import com.example.springjpa.repo.StudentRepo;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    public Student saveStudent(Student student){
       return studentRepo.save(student);
    }
    public List<Student> findStudentAll(){
        return studentRepo.findAll();
    }
    public Student findStudentByName(String name){
        return studentRepo.findStudentByName(name).orElseThrow(() -> new NoSuchElementException("bele bir element yoxdur"));
    }
    public Student findStudentById(Long id){
        return studentRepo.findById(id).orElseThrow(() -> new NoSuchElementException("bele bir element yoxdur"));
    }
    public Student updateStudent(String name,Long id){
        Student student=findStudentById(id);
        student.setName(name);
      return saveStudent(student);
    }
    public void deleteStudent(String name){

       studentRepo.delete(findStudentByName(name));
    }
}
