public class ArbolBinarioBusqueda<T extends Comparable<T>> {
    private class Nodo {
        T dato;
        Nodo izquierdo;
        Nodo derecho;

        Nodo(T dato) {
            this.dato = dato;
            izquierdo = derecho = null;
        }
    }

    private Nodo raiz;

    public void insertar(T elemento) {
        raiz = insertarRec(raiz, elemento);
    }

    private Nodo insertarRec(Nodo nodo, T elemento) {
        if (nodo == null) {
            return new Nodo(elemento);
        }
        if (elemento.compareTo(nodo.dato) < 0) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, elemento);
        } else if (elemento.compareTo(nodo.dato) > 0) {
            nodo.derecho = insertarRec(nodo.derecho, elemento);
        } else {
            throw new IllegalArgumentException("El elemento ya existe en el árbol");
        }
        return nodo;
    }

    public void eliminar(T elemento) {
        raiz = eliminarRec(raiz, elemento);
    }

    private Nodo eliminarRec(Nodo nodo, T elemento) {
        if (nodo == null) {
            throw new IllegalArgumentException("El elemento no existe en el árbol");
        }
        if (elemento.compareTo(nodo.dato) < 0) {
            nodo.izquierdo = eliminarRec(nodo.izquierdo, elemento);
        } else if (elemento.compareTo(nodo.dato) > 0) {
            nodo.derecho = eliminarRec(nodo.derecho, elemento);
        } else {
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }
            nodo.dato = obtenerMinimo(nodo.derecho);
            nodo.derecho = eliminarRec(nodo.derecho, nodo.dato);
        }
        return nodo;
    }

    private T obtenerMinimo(Nodo nodo) {
        T minimo = nodo.dato;
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
            minimo = nodo.dato;
        }
        return minimo;
    }

    public T buscar(T elemento) {
        return buscarRec(raiz, elemento);
    }

    private T buscarRec(Nodo nodo, T elemento) {
        if (nodo == null) {
            return null;
        }
        if (elemento.compareTo(nodo.dato) < 0) {
            return buscarRec(nodo.izquierdo, elemento);
        } else if (elemento.compareTo(nodo.dato) > 0) {
            return buscarRec(nodo.derecho, elemento);
        } else {
            return nodo.dato;
        }
    }

    public void inOrden() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(Nodo nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.izquierdo);
            System.out.println(nodo.dato+" ");
            inOrdenRec(nodo.derecho);
        }
    }



}
