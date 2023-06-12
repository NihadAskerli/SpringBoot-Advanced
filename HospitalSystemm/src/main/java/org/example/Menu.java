package org.example;

import org.example.model.Doctor;
import org.example.model.Patient;;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public Doctor addProduct() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("doctorun melumatlari");
        System.out.println("doctorun id-sini daxil edin");
        Long id = sc1.nextLong();
        System.out.println("doctorun name-ni daxil edin");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("doctorun speciality-sini daxil edin");
        Scanner scanner2 = new Scanner(System.in);
        String speciality = scanner2.nextLine();
        System.out.println("doctorun photo Linkini-unu daxil edin");
        Scanner scanner3 = new Scanner(System.in);
        String photoDoctor = scanner3.nextLine();
        List<Patient>patientList=new ArrayList<>();
        Doctor doctor = new Doctor(id,name,speciality,patientList,photoDoctor);
        return doctor;
    }

    public Patient addPatient() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("patientin melumatlari");
        System.out.println("patientin id-sini daxil edin");
        Long id = sc1.nextLong();
        System.out.println("patientin name-ni daxil edin");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("patientin photo Linkini-unu daxil edin");
        Scanner scanner3 = new Scanner(System.in);
        String photoPatient = scanner3.nextLine();
        Patient patient = new Patient(id,name,photoPatient);
        return patient;
    }

}
