public class Stack<T> {
    private Nodo<T> tope;
    private int tamano;
    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
        }
    }

    public Stack() {
        tope = null;
        tamano = 0;
    }

    public boolean isEmpty() {
        return tope == null;
    }
    public int length() {
        return tamano;
    }
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        T dato = tope.dato;
        tope = tope.siguiente;
        tamano--;
        return dato;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return tope.dato;
    }

    public void push(T value) {
        Nodo<T> nuevoNodo = new Nodo<>(value);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
        tamano++;
    }
}
