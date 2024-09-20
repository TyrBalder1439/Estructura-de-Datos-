import java.util.LinkedList;
import java.util.Queue;

public class ColaConPrioridadAcotada<T> {
    private Queue<T>[] colas;
    private int maxPrioridad;

    public ColaConPrioridadAcotada(int niveles) {
        this.maxPrioridad = niveles;
        colas = new LinkedList[niveles + 1];
        for (int i = 0; i <= niveles; i++) {
            colas[i] = new LinkedList<>();
        }
    }
    public boolean estaVacia() {
        for (int i = 1; i <= maxPrioridad; i++) {
            if (!colas[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }
    public int longitud() {
        int longitudTotal = 0;
        for (int i = 1; i <= maxPrioridad; i++) {
            longitudTotal += colas[i].size();
        }
        return longitudTotal;
    }
    public void encolar(int prioridad, T elemento) {
        if (prioridad >= 1 && prioridad <= maxPrioridad) {
            colas[prioridad].offer(elemento);
        } else {
            System.out.println("Prioridad no válida.");
        }
    }
    public T desencolar() {
        for (int i = 1; i <= maxPrioridad; i++) {
            if (!colas[i].isEmpty()) {
                return colas[i].poll();
            }
        }
        System.out.println("No hay elementos en la cola.");
        return null;
    }
    public String to_string() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= maxPrioridad; i++) {
            if (!colas[i].isEmpty()) {
                sb.append("Prioridad " + i + ": ");
                for (T elemento : colas[i]) {
                    sb.append(elemento.toString() + " | ");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
