package org.example.service.inter;

import org.example.model.Doctor;
import org.example.model.Patient;

import java.util.List;

public interface DoctorInter {

    void addDoctor(Doctor doctor);

    void addPatientToDoctor(String name, Patient patient);

    void deletePatientFromDoctor(String name, Patient patient);

    void changeDoctorPhoto(String name,String link);

}
