package ui;

import users.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {
    public static ArrayList<Doctor> doctorsAddAvailableAppointments = new ArrayList<>();
    public static void showDacotoMenu(){
        int response = 0;
        do {
            System.out.println("doctor");
            System.out.println("welcome " + UIMenu.doctorLogged.getName());
            System.out.println("1. add available appointment");
            System.out.println("2. My scheduble appointment");
            System.out.println("0. logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showAddAvilableAppintmentMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        }while (response != 0);
    }

    private static void showAddAvilableAppintmentMenu(){
        int response = 0;
        do {
            System.out.println(":: Add available apointment");
            System.out.println(":: select a month");

            for (int i = 0; i < 3; i++) {
                int j = i + 1;
                System.out.println(j + ". " + UIMenu.MONTHS[i]);
            }
            System.out.println("0. return");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if(response > 0 && response < 4){
                int monthSelected = response;
                System.out.println(monthSelected + ". " + "estas en este mes " + UIMenu.MONTHS[monthSelected-1]);
                System.out.println("insert the date available: [ss/mm/yyyy]");
                String date = sc.nextLine();

                System.out.println("you date is: " + date + "1. correct " + "2. no correct");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2 ) continue;

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("insert the time for date: " + date);
                    time = sc.nextLine();
                    System.out.println("you date is: " + time + "1. correct " + "2. no correct");
                    responseTime = Integer.valueOf(sc.nextLine());
                } while (responseTime ==2);

                UIMenu.doctorLogged.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointments(UIMenu.doctorLogged);

            } else if (response == 0) {
                showDacotoMenu();
            }

        }while (response != 0);
    }

    private  static void checkDoctorAvailableAppointments(Doctor doctor){
        if (doctor.getAvailableAppointments().size() > 0
            && !doctorsAddAvailableAppointments.contains(doctor)){
            doctorsAddAvailableAppointments.add(doctor);
        }
    }
}
