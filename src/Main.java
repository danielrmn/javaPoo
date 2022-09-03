import users.Doctor;
import users.Nurse;
import users.Patient;
import users.Users;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Doctor myDoctor = new Doctor("Daniel Lopez", "danielrmn@gmail.com");
        Patient myPatient = new Patient("Juan", "juan@gmail.com");

        // poliformismo con clase abstracta
        Users doctorABS = new Doctor("Pedro", "pedro.com");
        doctorABS.showDataUser();
        Users nurseABS = new Nurse("ana", "ana.com");
        nurseABS.showDataUser();
        Users patientABS = new Patient("fabiam", "fabian.com");
        patientABS.showDataUser();

        // clase abstracta
        Users user1 = new Users("pepe", "pepe.com") {
            @Override
            public void showDataUser() {
                System.out.println("doctor");
                System.out.println("trabaja en cruz azul xd");
            }
        };
        user1.showDataUser();

        /*myDoctor.addAvailableAppointment(new Date(), "4pm");
        myDoctor.addAvailableAppointment(new Date(), "10am");
        myDoctor.addAvailableAppointment(new Date(), "1pm");
        for (Doctor.AvailableAppointment aA: myDoctor.getAvailableAppointments()) {
            System.out.println(aA.getDate() + " " + aA.getTime());
        }*/

        System.out.println(myPatient);
        System.out.println(myDoctor);
    }
}
