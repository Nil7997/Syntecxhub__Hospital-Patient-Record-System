
package com.hospital.service;

import java.util.List;

import com.hospital.dao.PatientDAO;
import com.hospital.dao.PatientDAOImpl;
import com.hospital.model.Patient;

public class PatientService 
{
	private PatientDAO dao = new PatientDAOImpl();

	public boolean registerPatient(Patient patient) 
	{
		if (patient.getAge() <= 0) 
		{
			throw new IllegalArgumentException("Invalid Age");
		}

		if (!patient.getContact().matches("[0-9]{10}")) 
		{
			throw new IllegalArgumentException("Invalid Contact Number");
		}

		return dao.addPatient(patient);
	}

	public boolean updateHistory(int id, String history) 
	{
		return dao.updateMedicalHistory(id, history);
	}

	public Patient findPatient(int id) 
	{
		return dao.getPatientById(id);
	}

	public List<Patient> listPatients() 
	{
		return dao.getAllPatients();
	}

	public boolean removePatient(int id) 
	{
		return dao.deletePatient(id);
	}
}
