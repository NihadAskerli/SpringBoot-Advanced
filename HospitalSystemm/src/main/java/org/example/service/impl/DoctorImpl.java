package org.example.service.impl;

import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.service.inter.DoctorInter;
import java.util.ArrayList;
import java.util.List;

public class DoctorImpl implements DoctorInter {
    public static List<Doctor>doctors=new ArrayList<>();

    @Override
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    @Override
    public void addPatientToDoctor(String name, Patient patient) {
          Doctor doctor1=doctors.stream().filter(doctor -> doctor.getName().equals(name)).findFirst().get();
           doctors.remove(doctor1);
           doctor1.getPatients().add(patient);
           doctors.add(doctor1);
       }


    @Override
    public void deletePatientFromDoctor(String name, Patient patient) {
        Doctor doctor=doctors.stream().filter(doctor1 -> doctor1.getName().equals(name)).findFirst().get();

          doctor.getPatients().remove(patient);
          System.out.println("silindi");
      }

    @Override
    public void changeDoctorPhoto(String name, String link) {
        Doctor doctor=doctors.stream().findAny().get();

        if (doctors.stream().anyMatch(doctor1 -> doctor1.getName().equals(name))){
            doctor.setPhotoDoctor(link);
        }
    }

}
