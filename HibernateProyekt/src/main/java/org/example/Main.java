package org.example;

import org.example.service.impl.StudentImpl;

public class Main {
    public static void main(String[] args) {
        StudentImpl student=new StudentImpl();
        System.out.println(student.getByName("Ayten"));;
    }
}