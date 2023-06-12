package org.example.service.impl;

import org.example.models.Student;
import org.example.service.inter.StudentInter;
import java.util.ArrayList;
import java.util.List;

public class StudentImpl implements StudentInter {
    public static List<Student> students = new ArrayList<>();

    public Student findIndex(String finCode) {

        Student student = null;
        for (Student student1 : students) {
            if (student1.getFinCode().equals(finCode)) {
                student = student1;
            }
        }
        return student;
    }

    @Override
    public Student addStudent(Student student) {
        students.add(student);
        return students.get(students.size() - 1);
    }

    @Override
    public Student deleteStudent(String finCode) {
        Student student = null;

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getFinCode().equals(finCode)) {
                student = students.remove(i);
            }
        }

        return student;
    }

    @Override
    public Student getByName(String name) {
        Student student = null;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                student = students.get(i);
            }

        }
        return student;
    }

    @Override
    public void deleteByName(String name) {
        students.remove(getByName(name));
    }

    @Override
    public Student addStudentToTeacher(String name) {
        Student student = null;

        for (int i = 0; i < TeacherImpl.teachers.size(); i++) {
            if (TeacherImpl.teachers.get(i).getName().equals(name)) {
                TeacherImpl.teachers.get(i).getStudents().addAll( null);
            }
        }
        return student;
    }
}

