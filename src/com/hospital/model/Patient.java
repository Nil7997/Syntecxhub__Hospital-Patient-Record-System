package com.hospital.model;

public class Patient 
{
    private int patientId;
    private String name;
    private int age;
    private String gender;
    private String contact;
    private String medicalHistory;

    public Patient() {}

    public Patient(String name, int age, String gender, String contact, String medicalHistory) 
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.medicalHistory = medicalHistory;
    }

    // Getters and Setters

    public int getPatientId() 
    { return patientId; }
    public void setPatientId(int patientId) 
    { this.patientId = patientId; }

    public String getName() 
    { return name; }
    public void setName(String name) 
    { this.name = name; }

    public int getAge() 
    { return age; }
    public void setAge(int age) 
    { this.age = age; }

    public String getGender() 
    { return gender; }
    public void setGender(String gender) 
    { this.gender = gender; }

    public String getContact() 
    { return contact; }
    public void setContact(String contact) 
    { this.contact = contact; }

    public String getMedicalHistory()
    { return medicalHistory; }
    public void setMedicalHistory(String medicalHistory) 
    { this.medicalHistory = medicalHistory; }
}
