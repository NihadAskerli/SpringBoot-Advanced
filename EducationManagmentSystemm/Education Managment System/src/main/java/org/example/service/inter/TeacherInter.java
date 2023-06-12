package org.example.service.inter;

import org.example.models.Teacher;

public interface TeacherInter {
    Teacher teacherAdd(Teacher teacher);

     Teacher getByNameTeacher(String name);

     Teacher deleteByName(String name);


    }
