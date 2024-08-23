package com.mycompany.conjuntoadt;
import java.util.ArrayList;

public class ConjuntoADT<T>{
    private ArrayList<T> conjunto;

    public ConjuntoADT() {
        this.conjunto = new ArrayList<>();
    }
    public int longitud() {
        return this.conjunto.size();
    }   
    public boolean contiene(T elemento) {
        return this.conjunto.contains(elemento);
    }
    
    public void agregar(T elemento) {
        if (!this.conjunto.contains(elemento)) {
            this.conjunto.add(elemento);
        }else {
            System.out.println("El elemento a a gregar no existe");
        }
    }    
    public void eliminar(T elemento) {
        T tmp = elemento;
        if (this.conjunto.contains(tmp)){
            this.conjunto.remove(tmp);            
        }else {
            System.out.println("El elemento a eliminar no existe");
        }
    }    
    public boolean equals(ConjuntoADT<T> otroConjunto) {
        return this.conjunto.containsAll(otroConjunto.conjunto) 
                && otroConjunto.conjunto.containsAll(this.conjunto);
    }
    
    public boolean esSubConjunto(ConjuntoADT<T> otroConjunto) {
        return otroConjunto.conjunto.containsAll(this.conjunto);
    }

    public ConjuntoADT<T> union(ConjuntoADT<T> otroConjunto) {
        ConjuntoADT<T> resultado = new ConjuntoADT<>();
        resultado.conjunto.addAll(this.conjunto);
        for (T elemento : otroConjunto.conjunto) {
            if (!resultado.conjunto.contains(elemento)) {
                resultado.conjunto.add(elemento);
            }
        }
        return resultado;
    }

    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otroConjunto) {
        ConjuntoADT<T> resultado = new ConjuntoADT<>();
        for (T elemento : this.conjunto) {
            if (otroConjunto.conjunto.contains(elemento)) {
                resultado.conjunto.add(elemento);
            }
        }
        return resultado;
    }

    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otroConjunto) {
        ConjuntoADT<T> resultado = new ConjuntoADT<>();
        for (T elemento : this.conjunto) {
            if (!otroConjunto.conjunto.contains(elemento)) {
                resultado.conjunto.add(elemento);
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        return conjunto.toString();
    }
}
