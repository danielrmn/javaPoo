package users;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends Users {
    private double weight;
    private double height;
    private String blood;
    private ArrayList<AppointmentdoDoctor> appointmentdoDoctors = new ArrayList<>();
    //private ArrayList<AppointmentdoNurse> appointmentdoNurses = new ArrayList<>();

    //metodos
    public Patient(String name, String email){
        super(name, email);
        System.out.println("el paciente asignado es: " + name + " " + email);
    }


//    getters y setters
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public ArrayList<AppointmentdoDoctor> getAppointmentdoDoctors() {
        return appointmentdoDoctors;
    }

    public void addAppointmentdoDoctors(Doctor doctor, Date date, String time) {
        AppointmentdoDoctor  appointmentdoDoctor = new AppointmentdoDoctor(this, doctor);
        appointmentdoDoctor.schedule(date, time);
        appointmentdoDoctors.add(appointmentdoDoctor);
    }

    // spbre escritura

    @Override
    public String toString() {
        return "Users.Patient{" +
                "weight=" + weight +
                ", height=" + height +
                ", blood='" + blood + '\'' +
                '}';
    }

    @Override
    public void showDataUser() {
        System.out.println("paciente ");
        System.out.println("historial clinico");
    }
}
