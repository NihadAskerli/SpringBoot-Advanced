package org.example;

public class Student {
    private static Student student=null;
    private Student(){

    }
    public static Student student(){
        if(student==null){
            student=new Student();
            return student;
        }else {
            return student;
        }

    }
public void foo(){
    System.out.println("student"+Student.class.getName());
}
}
