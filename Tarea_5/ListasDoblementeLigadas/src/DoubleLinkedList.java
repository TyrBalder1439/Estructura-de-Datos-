public class DoubleLinkedList<T> {
    private NodoDoble<T> head;
    private NodoDoble<T> tail;
    private int tamanio;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.tamanio = 0;
    }
    public boolean estaVacia() {
        return this.head == null && this.tail == null;
    }
    public int getTamanio() {
        return tamanio;
    }
    public void agregarAlInicio(T valor) {
        NodoDoble<T> nuevo = new NodoDoble<>(valor);
        if (this.estaVacia()) {
            this.head = nuevo;
            this.tail = nuevo;
        } else {
            this.head.setAnterior(nuevo);
            nuevo.setSiguiente(this.head);
            this.head = nuevo;
        }
        this.tamanio++;
    }

    public void agregarAlFinal(T valor) {
        NodoDoble<T> nuevo = new NodoDoble<>(valor);
        if (this.estaVacia()) {
            this.head = nuevo;
            this.tail = nuevo;
        } else {
            this.tail.setSiguiente(nuevo);
            nuevo.setAnterior(this.tail);
            this.tail = nuevo;
        }
        this.tamanio++;
    }
    public void agregarDespuesDe(T referencia, T valor) {
        NodoDoble<T> aux = this.head;
        while (aux != null && !aux.getData().equals(referencia)) {
            aux = aux.getSiguiente();
        }
        if (aux == null) {
            System.out.println("No existe la referencia!!!");
        } else {
            NodoDoble<T> nuevo = new NodoDoble<>(valor);
            nuevo.setSiguiente(aux.getSiguiente());
            nuevo.setAnterior(aux);
            if (aux.getSiguiente() != null) {
                aux.getSiguiente().setAnterior(nuevo);
            } else {
                tail = nuevo;  // Si es el último nodo, actualizamos tail
            }
            aux.setSiguiente(nuevo);
            this.tamanio++;
        }
    }
    public T obtener(int posicion) {
        if (posicion < 0 || posicion >= tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        NodoDoble<T> aux = this.head;
        for (int i = 0; i < posicion; i++) {
            aux = aux.getSiguiente();
        }
        return aux.getData();
    }

    public void eliminarElPrimero() {
        if (!estaVacia()) {
            if (this.head == this.tail) {  // Solo un elemento
                this.head = this.tail = null;
            } else {
                this.head = this.head.getSiguiente();
                this.head.setAnterior(null);
            }
            this.tamanio--;
        }
    }
    public void eliminarElFinal() {
        if (!estaVacia()) {
            if (this.head == this.tail) {  // Solo un elemento
                this.head = this.tail = null;
            } else {
                this.tail = this.tail.getAnterior();
                this.tail.setSiguiente(null);
            }
            this.tamanio--;
        }
    }
    public void eliminar(int posicion) {
        if (posicion < 0 || posicion >= tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        if (posicion == 0) {
            eliminarElPrimero();
        } else if (posicion == tamanio - 1) {
            eliminarElFinal();
        } else {
            NodoDoble<T> aux = this.head;
            for (int i = 0; i < posicion; i++) {
                aux = aux.getSiguiente();
            }
            aux.getAnterior().setSiguiente(aux.getSiguiente());
            aux.getSiguiente().setAnterior(aux.getAnterior());
            this.tamanio--;
        }
    }
    public int buscar(T valor) {
        NodoDoble<T> aux = this.head;
        int posicion = 0;
        while (aux != null) {
            if (aux.getData().equals(valor)) {
                return posicion;
            }
            aux = aux.getSiguiente();
            posicion++;
        }
        return -1;
    }
    public void actualizar(T aBuscar, T valor) {
        NodoDoble<T> aux = this.head;
        while (aux != null) {
            if (aux.getData().equals(aBuscar)) {
                aux.setData(valor);
                return;
            }
            aux = aux.getSiguiente();
        }
    }
    public void transversal(int direccion) {
        if (direccion == 1) {
            NodoDoble<T> aux = this.tail;
            while (aux != null) {
                System.out.print(aux + " ");
                aux = aux.getAnterior();
            }
        } else {
            NodoDoble<T> aux = this.head;
            while (aux != null) {
                System.out.print(aux + " ");
                aux = aux.getSiguiente();
            }
        }
        System.out.println("");
    }
}
