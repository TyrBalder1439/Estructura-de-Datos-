public class ClienteBanco {
    private String nombre;
    private String perfil;
    private double saldo;

    public ClienteBanco(String nombre, String perfil, double saldo) {
        this.nombre = nombre;
        this.perfil = perfil;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPerfil() {
        return perfil;
    }

    public double getSaldo() {
        return saldo;
    }

    public void retirarDinero(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Se han retirado $" + cantidad + " de la cuenta de " + nombre);
        } else {
            System.out.println("Saldo insuficiente para " + nombre);
        }
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + ", Perfil: " + perfil + ", Saldo: $" + saldo;
    }
}
