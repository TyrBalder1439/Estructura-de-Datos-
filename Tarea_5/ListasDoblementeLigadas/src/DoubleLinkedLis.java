public class DoubleLinkedLis <T>{
        private NodoDoble<T> head;
        private NodoDoble<T> tail;
        private int tamanio;

        public DoubleLinkedLis() {
            this.head = null;
            this.tail = null;
            this.tamanio = 0;
        }

        public boolean estaVacia() {
            return head == null;
        }

        public int getTamanio() {
            return tamanio;
        }

        public void agregarAlInicio(T valor) {
            NodoDoble<T> nuevo = new NodoDoble<>(valor);
            if (estaVacia()) {
                head = tail = nuevo;
            } else {
                nuevo.siguiente = head;
                head.anterior = nuevo;
                head = nuevo;
            }
            tamanio++;
        }

        public void agregarAlFinal(T valor) {
            NodoDoble<T> nuevo = new NodoDoble<>(valor);
            if (estaVacia()) {
                head = tail = nuevo;
            } else {
                tail.siguiente = nuevo;
                nuevo.anterior = tail;
                tail = nuevo;
            }
            tamanio++;
        }

        public void agregarDespuesDe(T referencia, T valor) {
            NodoDoble<T> actual = head;
            while (actual != null && !actual.dato.equals(referencia)) {
                actual = actual.siguiente;
            }
            if (actual != null) {
                NodoDoble<T> nuevo = new NodoDoble<>(valor);
                nuevo.siguiente = actual.siguiente;
                nuevo.anterior = actual;
                if (actual.siguiente != null) {
                    actual.siguiente.anterior = nuevo;
                } else {
                    tail = nuevo;
                }
                actual.siguiente = nuevo;
                tamanio++;
            }
        }

        public T obtener(int posicion) {
            if (posicion >= 0 && posicion < tamanio) {
                NodoDoble<T> actual = head;
                for (int i = 0; i < posicion; i++) {
                    actual = actual.siguiente;
                }
                return actual.dato;
            }
            return null; // Retorna null si la posición no es válida
        }

        public void eliminarElPrimero() {
            if (!estaVacia()) {
                if (head == tail) { // Solo un elemento
                    head = tail = null;
                } else {
                    head = head.siguiente;
                    head.anterior = null;
                }
                tamanio--;
            }
        }

        public void eliminarElFinal() {
            if (!estaVacia()) {
                if (head == tail) { // Solo un elemento
                    head = tail = null;
                } else {
                    tail = tail.anterior;
                    tail.siguiente = null;
                }
                tamanio--;
            }
        }

        public void eliminar(int posicion) {
            if (posicion >= 0 && posicion < tamanio) {
                if (posicion == 0) {
                    eliminarElPrimero();
                } else if (posicion == tamanio - 1) {
                    eliminarElFinal();
                } else {
                    NodoDoble<T> actual = head;
                    for (int i = 0; i < posicion; i++) {
                        actual = actual.siguiente;
                    }
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                    tamanio--;
                }
            }
        }

        public int buscar(T valor) {
            NodoDoble<T> actual = head;
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
            NodoDoble<T> actual = head;
            while (actual != null) {
                if (actual.dato.equals(aBuscar)) {
                    actual.dato = valor;
                    return;
                }
                actual = actual.siguiente;
            }
        }

        public void transversal(String direccion) {
            if (direccion.equalsIgnoreCase("derecha")) {
                NodoDoble<T> actual = head;
                while (actual != null) {
                    System.out.print(actual.dato + " ");
                    actual = actual.siguiente;
                }
            } else if (direccion.equalsIgnoreCase("izquierda")) {
                NodoDoble<T> actual = tail;
                while (actual != null) {
                    System.out.print(actual.dato + " ");
                    actual = actual.anterior;
                }
            }
            System.out.println();
        }
    }
