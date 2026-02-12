package com.hospital.app;

import java.util.List;
import java.util.Scanner;

import com.hospital.model.Patient;
import com.hospital.service.PatientService;

public class MainApp 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        PatientService service = new PatientService();
        int choice;

        do {
            System.out.println("\n===== Hospital Patient Record System =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patient");
            System.out.println("3. View All Patients");
            System.out.println("4. Update Medical History");
            System.out.println("5. Delete Patient");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Gender: ");
                    String gender = sc.nextLine();
                    System.out.print("Contact: ");
                    String contact = sc.nextLine();
                    System.out.print("Medical History: ");
                    String history = sc.nextLine();

                    Patient p = new Patient(name, age, gender, contact, history);
                    System.out.println(service.registerPatient(p) ? "Patient Added" : "Failed");
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    Patient patient = service.findPatient(id);
                    if (patient != null)
                        System.out.println(patient.getName() + " | " + patient.getAge() + " | " + patient.getMedicalHistory());
                    else
                        System.out.println("Patient Not Found");
                    break;

                case 3:
                    List<Patient> list = service.listPatients();
                    list.forEach(pt -> System.out.println(
                            pt.getPatientId() + " | " +
                            pt.getName() + " | " +
                            pt.getAge() + " | " +
                            pt.getGender()));
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New History: ");
                    String newHistory = sc.nextLine();
                    System.out.println(service.updateHistory(pid, newHistory) ? "Updated" : "Failed");
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    int delId = sc.nextInt();
                    System.out.println(service.removePatient(delId) ? "Deleted" : "Failed");
                    break;

                case 6:
                    System.out.println("Thank You");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);
    }
}
