package org.example;

import org.example.service.impl.DoctorImpl;
import org.example.service.impl.PatientImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Boolean b = true;
        DoctorImpl doctorImpl=new DoctorImpl();
        Menu menu=new Menu();

        System.out.println(
                        "1-i  basanda doctor elave edilecek \n" +
                        "2-ni basanda doctora patient elave edilecek \n" +
                        "3-u  basanda doctordan patient silinecek \n" +
                        "4-u  basanda doctorun photosu deyiwecek \n" +
                        "5-i  basanda butun doctorlar gosterilecek \n" +
                        "6-ni basanda butun patientler gosterilecek \n" +
                        "7-ni basanda patientin photosu deyiwecek \n" +
                        "8-ni basanda sistemden cixilacaq ");

        while (b) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Secmek istediyiniz operation nomresini daxil edin: ");
            int operation = scanner.nextInt();

            if (operation == 1) {
                doctorImpl.addDoctor(menu.addProduct());
            } else if (operation == 2) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Doctorun name-ni daxil edin: ");
                String name = scanner1.nextLine();
                doctorImpl.addPatientToDoctor(name,menu.addPatient());
            } else if (operation == 3) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Doctorun name-ni daxil edin: ");
                String name = scanner1.nextLine();
                doctorImpl.deletePatientFromDoctor(name,menu.addPatient());
            } else if (operation == 4) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Doctorun name-ni daxil edin: ");
                String name = scanner1.nextLine();
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Doctorun photosunun link-ini daxil edin: ");
                String link = scanner2.nextLine();
                doctorImpl.changeDoctorPhoto(name,link);
            } else if (operation == 5) {
                DoctorImpl.doctors.stream().forEach(System.out::println);
            } else if (operation == 6) {
                PatientImpl.patients.stream().forEach(System.out::println);
            } else if (operation == 6) {
                PatientImpl patientImpl=new PatientImpl();
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Patientin name-ni daxil edin: ");
                String name = scanner1.nextLine();
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Patientin photosunun link-ini daxil edin: ");
                String link = scanner2.nextLine();
                patientImpl.changePatientPhoto(name,link);
            }else if (operation == 7) {
                b = false;
                System.out.println("Sistemden chixildi");
            }
        }
    }
}