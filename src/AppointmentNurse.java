import users.ISchedulable;
import users.Nurse;
import users.Patient;

import java.sql.Time;
import java.util.Date;

public class AppointmentNurse implements ISchedulable{
    private int id;
    private Nurse nurse;
    private Patient patient;
    private Date date;
    private Time time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public void schedule(Date date, String time) {

    }
}
