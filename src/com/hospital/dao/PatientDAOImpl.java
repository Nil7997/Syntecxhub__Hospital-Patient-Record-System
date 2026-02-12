
package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.model.Patient;
import com.hospital.util.DBConnection;

public class PatientDAOImpl implements PatientDAO
    {
        
    @Override
    public boolean addPatient(Patient patient) 
    {
        String sql = "INSERT INTO patients(name, age, gender, contact, medical_history) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) 
        {
            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getContact());
            ps.setString(5, patient.getMedicalHistory());

            return ps.executeUpdate() > 0;

        } 
          catch (Exception e) 
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateMedicalHistory(int patientId, String history) 
    {
        String sql = "UPDATE patients SET medical_history = ? WHERE patient_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) 
        {
            ps.setString(1, history);
            ps.setInt(2, patientId);

            return ps.executeUpdate() > 0;

        } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        return false;
    }

    @Override
    public Patient getPatientById(int patientId) 
    {
        String sql = "SELECT * FROM patients WHERE patient_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) 
        {
            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) 
            {
                Patient p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
                p.setGender(rs.getString("gender"));
                p.setContact(rs.getString("contact"));
                p.setMedicalHistory(rs.getString("medical_history"));
                return p;
            }

        } 
            catch (Exception e) 
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Patient> getAllPatients() 
    {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM patients";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) 
        {
            while (rs.next()) 
            {
                Patient p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
                p.setGender(rs.getString("gender"));
                p.setContact(rs.getString("contact"));
                p.setMedicalHistory(rs.getString("medical_history"));
                list.add(p);
            }

        } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        return list;
    }

    @Override
    public boolean deletePatient(int patientId) 
    {
        String sql = "DELETE FROM patients WHERE patient_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) 
        {
            ps.setInt(1, patientId);
            return ps.executeUpdate() > 0;

        }
            catch (Exception e) 
        {
            e.printStackTrace();
        }
        return false;
    }
}
