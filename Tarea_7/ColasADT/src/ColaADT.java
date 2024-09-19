import java.util.LinkedList;

public class ColaADT<T> {
    private LinkedList<T> cola;

    public ColaADT() {
        cola = new LinkedList<>();
    }

    public void encolar(T elemento) {
        cola.addLast(elemento);
    }

    public T desencolar() {
        return cola.pollFirst();
    }

    public T frente() {
        return cola.peekFirst();
    }

    public void mostrarCola() {
        System.out.println(cola);
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }
}
