public class Main {
        public static void main(String[] args) {
            ColaADT<Paciente> colaPacientes = new ColaADT<>();
            colaPacientes.encolar(new Paciente("Anaximandro", 21));
            colaPacientes.encolar(new Paciente("Aquiles", 25));
            colaPacientes.encolar(new Paciente("Samira", 22));
            colaPacientes.encolar(new Paciente("Antonio", 27));
            System.out.println("Pacientes en espera: ");
            colaPacientes.mostrarCola();
            System.out.println("Paciente al frente: " + colaPacientes.frente());
            System.out.println("Atendiendo a: " + colaPacientes.desencolar());
            System.out.println("Pacientes en espera:");
            colaPacientes.mostrarCola();
            colaPacientes.encolar(new Paciente("Betsy", 27));
            colaPacientes.encolar(new Paciente("Idalea", 28));
            System.out.println("Atendiendo a: " + colaPacientes.desencolar());
            System.out.println("Pacientes en espera:");
            colaPacientes.mostrarCola();
        }
    }
