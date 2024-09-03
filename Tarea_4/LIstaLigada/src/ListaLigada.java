public class ListaLigada<T> {
        private class Nodo {
            T dato;
            Nodo siguiente;
            public Nodo(T dato) {
                this.dato = dato;
                this.siguiente = null;
            }
        }
        private Nodo head;
        private int tamanio;
        public ListaLigada() {
            this.head = null;
            this.tamanio = 0;
        }
        public boolean estaVacia() {
            return head == null;
        }
        public int getTamanio() {
            return tamanio;
        }
        public void agregarAlFinal(T valor) {
            Nodo nuevo = new Nodo(valor);
            if (estaVacia()) {
                head = nuevo;
            } else {
                Nodo actual = head;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
            }
            tamanio++;
        }
        public void agregarAlInicio (T valor) {
            Nodo nuevo = new Nodo(valor);
            nuevo.siguiente = head;
            head = nuevo;
            tamanio++;
        }
        public void agregarDespuesDe(T referencia, T valor) {
            Nodo actual = head;
            while (actual != null && !actual.dato.equals(referencia)) {
                actual = actual.siguiente;
            }
            if (actual != null) {
                Nodo nuevo = new Nodo(valor);
                nuevo.siguiente = actual.siguiente;
                actual.siguiente = nuevo;
                tamanio++;
            }
        }
        public void eliminar(int posicion) {
            if (posicion >= 0 && posicion < tamanio) {
                if (posicion == 0) {
                    eliminarElPrimero();
                } else {
                    Nodo actual = head;
                    for (int i = 0; i < posicion - 1; i++) {
                        actual = actual.siguiente;
                    }
                    actual.siguiente = actual.siguiente.siguiente;
                    tamanio--;
                }
            }
        }
        public void eliminarElPrimero() {
            if (!estaVacia()) {
                head = head.siguiente;
                tamanio--;
            }
        }
        public void eliminarElFinal() {
            if (!estaVacia()) {
                if (head.siguiente == null) {
                    head = null;
                } else {
                    Nodo actual = head;
                    while (actual.siguiente.siguiente != null) {
                        actual = actual.siguiente;
                    }
                    actual.siguiente = null;
                }
                tamanio--;
            }
        }
        public int buscar(T valor) {
            Nodo actual = head;
            int posicion = 0;
            while (actual != null) {
                if (actual.dato.equals(valor)) {
                    return posicion;
                }
                actual = actual.siguiente;
                posicion++;
            }
            return -1; // No encontrado
        }
        public void actualizar(T aBuscar, T valor) {
            Nodo actual = head;
            while (actual != null) {
                if (actual.dato.equals(aBuscar)) {
                    actual.dato = valor;
                    return;
                }
                actual = actual.siguiente;
            }
        }
        public void transversal() {
            Nodo actual = head;
            while (actual != null) {
                System.out.println(actual.dato);
                actual = actual.siguiente;
            }
        }
}