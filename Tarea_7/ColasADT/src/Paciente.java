public class Paciente {
    private String nombre;
    private int edad;

    public Paciente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Paciente {" + "nombre=" + nombre  + ", edad=" + edad + '}';
    }
}
