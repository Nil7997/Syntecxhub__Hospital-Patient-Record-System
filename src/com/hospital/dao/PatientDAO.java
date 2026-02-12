package com.hospital.dao;

import java.util.List;

import com.hospital.model.Patient;

public interface PatientDAO {

    boolean addPatient(Patient patient);
    boolean updateMedicalHistory(int patientId, String history);
    Patient getPatientById(int patientId);
    List<Patient> getAllPatients();
    boolean deletePatient(int patientId);
}
