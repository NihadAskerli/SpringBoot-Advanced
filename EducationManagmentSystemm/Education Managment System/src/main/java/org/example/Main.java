package org.example;

import org.example.models.Student;
import org.example.operations.Operation;
import org.example.service.impl.StudentImpl;
import org.example.service.impl.TeacherImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Boolean b = true;
        StudentImpl studentImpl = new StudentImpl();
        Operation operation1=new Operation();
        TeacherImpl teacher=new TeacherImpl();
        System.out.println(
                        "1 Daxil edende Student Elave Olunacaq \n" +
                        "2 Daxil edende Name gore Student Silinecek \n" +
                        "3 Daxil edende Adina gore Axtaris Olunacaq \n" +
                        "4 Daxil edende Teacher Adina gore Student Elave olunacaq \n " +
                        "5 Daxil edende Nihad Add olunacaq");

        while (b){
            Scanner sc = new Scanner(System.in);
            System.out.println("Operation Nomresini Daxil Edin:");
            int numberMenu = sc.nextInt();

            if(numberMenu==1){
                Student student=operation1.addStudent();
                System.out.println(studentImpl.addStudent(student));
            } else if (numberMenu==2) {
                Scanner sc4=new Scanner(System.in);
                System.out.println("Name Daxil edin");
                String name=sc4.nextLine();
               studentImpl.deleteByName(name);
                System.out.println("Successfully deleted");
            } else if (numberMenu==3) {
                System.out.println(studentImpl.getByName(operation1.searchByName()));
            }else if (numberMenu==4) {
                System.out.println(studentImpl.addStudentToTeacher(operation1.addStudentToTeacher()));
            } else if (numberMenu==5) {
                teacher.addNihad(operation1.addStudent());
            } else if (numberMenu==0) {
                b=false;
                System.out.println("Menudan cixis etdiniz");
            }
        }





    }

}