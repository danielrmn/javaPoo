package users;

public class Patient extends Users {
    private double weight;
    private double height;
    private String blood;

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
