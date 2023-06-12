package org.example.service.impl;

import org.example.models.Student;
import org.example.models.Teacher;
import org.example.service.inter.TeacherInter;
import java.util.ArrayList;
import java.util.List;

public class TeacherImpl implements TeacherInter {
    public static List<Teacher> teachers=new ArrayList<>();
    @Override
    public Teacher teacherAdd(Teacher teacher){
        teachers.add(teacher);
        teachers.get(0).setStudents(StudentImpl.students);
        return teachers.get(teachers.size()-1);
    }
    @Override
    public Teacher getByNameTeacher(String name){
        Teacher teacher=null;
        for (int i=0;i<teachers.size();i++){
            if (teachers.get(i).getName().equals(name)){
                teacher=teachers.get(i);
            }
        }
        return teacher;
    }

    public void printTeacher(){
        for (int i=0;i<teachers.size();i++){
            System.out.println(teachers);
        }
    }

    @Override
    public Teacher deleteByName(String name){
        Teacher teacher=null;

        for (int i=0;i<teachers.size();i++){
            if (teachers.get(i).getName().equals(name)){
                teacher=teachers.remove(i);
            }
        }
        return teacher;
    }
    public void addNihad( Student student){
        Teacher teacher1=null;
        for (Teacher teacher:teachers
        ) {
            if(teacher.getName().equals("Nihad")){
                teacher1=teacher;
            }
        }
        teacher1.getStudents().add(student);
    }
}