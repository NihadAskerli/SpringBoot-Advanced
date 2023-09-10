package com.example.springjpa.controller;

import com.example.springjpa.models.Student;
import com.example.springjpa.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/all")
    public List<Student> findAllStudent(){
        return studentService.findStudentAll();
    }
    @PostMapping("/save")
    public void saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }
    @GetMapping("/search")
    public Student findStudentByName(@RequestParam(name = "name") String name){
        return studentService.findStudentByName(name);
    }
    @GetMapping("/{name}")
    public Student pathStudentByName(@PathVariable(name = "name") String name){
        return studentService.findStudentByName(name);
    }
    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestParam("name")String name,@PathVariable("id") Long id){
        return studentService.updateStudent(name, id);
    }
    @DeleteMapping("/delete")
    public void updateStudent(@RequestParam("name")String name){
         studentService.deleteStudent(name);
    }
}
