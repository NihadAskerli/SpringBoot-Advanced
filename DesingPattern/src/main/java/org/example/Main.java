package org.example;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
//     Studentinter studentinter=UseServiceObject.getServiceObject(args[0]);
//     if( studentinter!=null){
//         studentinter.add();
//     }
        Student student=Student.student();
        student.foo();
        UtilFunction utilFunction=new UtilFunction();
        System.out.println(   UtilFunction.getConsurmer());
    }
}