package ui;

import users.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {
    public static void showPatientManu(){
        int response =0;
        do {
            System.out.println("patient");
            System.out.println("welcome: " + UIMenu.patientLogged.getName());
            System.out.println("1. book an appoinment");
            System.out.println("2. My appointments");
            System.out.println("0. logut");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointment();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        }while (response !=0);
    }
    private static void showBookAppointmentMenu(){
        int response = 0;
        do {
            System.out.println("::book an appoinmet");
            System.out.println("::select date");
            //numeracion lista de fechas
            //indeice fecha seleccionada
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAddAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments
                        = UIDoctorMenu.doctorsAddAvailableAppointments.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointment = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppointment.put(Integer.valueOf(j), UIDoctorMenu.doctorsAddAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointment);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSeleted = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "");

            for (Map.Entry<Integer, Doctor> doc :doctorAvailableSeleted.entrySet()){
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() +
                    ". date " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                    ". time " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getTime());
            System.out.println("confirm your appointment: 1. yes 2. no ");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1){
                UIMenu.patientLogged.addAppointmentdoDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());

                showPatientManu();
            }

        }while (response != 0);
    }

    private static void showPatientMyAppointment(){
        int response = 0;
        do {
            System.out.println(":: My appointment");
            if (UIMenu.patientLogged.getAppointmentdoDoctors().size() == 0){
                System.out.println("don't have an appointment ");
                break;
            }
            for (int i = 0; i < UIMenu.patientLogged.getAppointmentdoDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " +
                        "date " + UIMenu.patientLogged.getAppointmentdoDoctors().get(i).getDate() +
                        "time " + UIMenu.patientLogged.getAppointmentdoDoctors().get(i).getTime() +
                "\n Doctor: " + UIMenu.patientLogged.getAppointmentdoDoctors().get(i).getDoctor());
            }
            System.out.println("0. return");
        }while (response !=0);
    }
}
