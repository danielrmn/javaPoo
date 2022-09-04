package ui;

import users.Doctor;
import users.Nurse;
import users.Patient;

import java.util.ArrayList;
import java.util.Scanner;


public class UIMenu {
    public static final String[] MONTHS = {"enero", "febrero", "marzo",  "mayo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "diciembre"};
    public static Patient patientLogged;
    public static Doctor doctorLogged;
    public static Nurse nurseLogged;
    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);

                    break;
                case 0:
                    showPatientMenu();
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

    static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Users.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 0; i < 3; i++) {
                        System.out.println(i + ". " + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }

    private static void authUser(int userType){
        // userType = 1 Doctor
        // userType = 2 patient

        //array de doctores
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("karla", "karla.com"));
        doctors.add(new Doctor("alejandro", "alejandro.com"));
        doctors.add(new Doctor("rocio", "rocio.com"));

        //array de pacientes
        ArrayList<Patient>patients = new ArrayList<>();
        patients.add(new Patient("anahi", "anahi.com"));
        patients.add(new Patient("carlos", "roberto.com"));
        patients.add(new Patient("lumberto", "lumberto.com"));


        boolean emailCorrect = false;
        do {
            System.out.println("Insert your email");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if(userType == 1)
            {
                for (Doctor d: doctors){
                    if (d.getEmail().equals(email)){
                        doctorLogged = d;
                        UIDoctorMenu.showDacotoMenu();
                    }
                }
            }
            if(userType == 2)
            {
                for (Patient p: patients){
                    if (p.getEmail().equals(email)){
                        patientLogged = p;
                    }
                }
            }
        }while (!emailCorrect);
    }
}
