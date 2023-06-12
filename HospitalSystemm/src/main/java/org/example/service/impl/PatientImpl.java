package org.example.service.impl;

import org.example.model.Patient;
import org.example.service.inter.PatientInter;
import java.util.ArrayList;
import java.util.List;

public class PatientImpl implements PatientInter {
    public static List<Patient> patients=new ArrayList<>();
    @Override
    public void changePatientPhoto(String name,String link) {
        Patient patient=patients.stream().findAny().get();

        if (patients.stream().anyMatch(patient1 -> patient1.getName().equals(name))){
            patient.setPhotoPatient(link);
        }
    }
}
