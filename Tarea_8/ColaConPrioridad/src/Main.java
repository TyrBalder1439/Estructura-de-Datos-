public class Main {
    public static void main(String[] args) {

        ColaConPrioridadAcotada<ClienteBanco> colaBanco = new ColaConPrioridadAcotada<>(5);
        ClienteBanco cliente1 = new ClienteBanco("Betzy", "Cliente nuevo", 5000);
        ClienteBanco cliente2 = new ClienteBanco("Citlalli", "Cliente nuevo", 6000);
        ClienteBanco cliente3 = new ClienteBanco("Andromeda", "No es cliente", 0);
        ClienteBanco cliente4 = new ClienteBanco("Anaximandro", "No es cliente", 0);
        ClienteBanco cliente5 = new ClienteBanco("Alexis", "No es cliente", 0);
        ClienteBanco celebridad = new ClienteBanco("Peso Pluma", "Celebridad", 10000000);

        colaBanco.encolar(4, cliente1);
        colaBanco.encolar(4, cliente2);
        colaBanco.encolar(5, cliente3);
        colaBanco.encolar(5, cliente5);
        colaBanco.encolar(5, cliente4);
        colaBanco.encolar(1, celebridad);

        System.out.println("Estado de la cola:");
        System.out.println(colaBanco.to_string());

        ClienteBanco clienteAtendido = colaBanco.desencolar();
        if (clienteAtendido != null) {
            System.out.println("Atendiendo a: " + clienteAtendido.getNombre());
            clienteAtendido.retirarDinero(10000);
        }
        ClienteBanco clienteFrecuente = new ClienteBanco("Poseidón", "Cliente frecuente", 8000);
        ClienteBanco clientePremium = new ClienteBanco("Zeus", "Cliente premium", 15000);
        colaBanco.encolar(3, clienteFrecuente);
        colaBanco.encolar(2, clientePremium);
        System.out.println("Estado de la cola:");
        System.out.println(colaBanco.to_string());
        clienteAtendido = colaBanco.desencolar();

        if (clienteAtendido != null) {
            System.out.println("Atendiendo a: " + clienteAtendido.getNombre());
        }
        System.out.println("Estado de la cola después de atender al clientes:");
        System.out.println(colaBanco.to_string());
        while (!colaBanco.estaVacia()) {
            clienteAtendido = colaBanco.desencolar();
            if (clienteAtendido != null) {
                System.out.println("Atendiendo a: " + clienteAtendido.getNombre());
            }
        }
        int longitudCola = colaBanco.longitud();
        System.out.println("El estado de la fila es: " + longitudCola);
        System.out.println(colaBanco.to_string());
    }
}
