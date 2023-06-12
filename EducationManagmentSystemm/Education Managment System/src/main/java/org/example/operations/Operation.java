package org.example.operations;

import org.example.models.Student;

import java.util.Scanner;

public class Operation {
    public Student addStudent(){
        Scanner sc1=new Scanner(System.in);
        System.out.println("Studentin melumatlari");
        System.out.println("studentin id sini daxil edin");
        Long id=sc1.nextLong();
        System.out.println("studentin fincodunu daxil edin");
        Scanner scanner=new Scanner(System.in);
        String finCode=scanner.nextLine();
        System.out.println("studentin name ni daxil edin");
        String name=scanner.nextLine();
        Student student=new Student(id,finCode,name);
        return student;
    }

    public String searchByName(){
        Scanner sc3=new Scanner(System.in);
        System.out.println("Name Daxil Edin");
        String searchWithName=sc3.nextLine();
        return searchWithName;
    }

    public String addStudentToTeacher(){
        Scanner sc5=new Scanner(System.in);
        System.out.println("Name Daxil Edin");
        String name=sc5.nextLine();
        return name;
    }
}
