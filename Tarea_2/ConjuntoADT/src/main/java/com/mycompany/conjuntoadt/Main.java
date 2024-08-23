
package com.mycompany.conjuntoadt;

public class Main {
    public static void main(String[] args) {
       
        ConjuntoADT<Integer> conjuntoA = new ConjuntoADT<>();
        ConjuntoADT<Integer> conjuntoB = new ConjuntoADT<>();

        conjuntoA.agregar(1);
        conjuntoA.agregar(2);
        conjuntoA.agregar(3);
        conjuntoB.agregar(3);
        conjuntoB.agregar(4);
        conjuntoB.agregar(5);
        
        System.out.println("imprimiendo conjunto A " + conjuntoA);
        System.out.println("imprimiendo conjunto B " + conjuntoB);        
        System.out.println("eliminarndo del conjunto A a 2");        
        conjuntoA.eliminar(2);        
        System.out.println("imprimiendo conjunto A " + conjuntoA);        
        System.out.println("¿El conjunto A contiene el 1? " + conjuntoA.contiene(1)); 
        System.out.println("¿El conjunto b contiene al 2?" + conjuntoB.contiene(2));       
        ConjuntoADT<Integer> union = conjuntoA.union(conjuntoB);
        System.out.println("Unión de A y B: " + union);        
        ConjuntoADT<Integer> interseccion = conjuntoA.interseccion(conjuntoB);
        System.out.println("Intersección de A y B: " + interseccion);         
        ConjuntoADT<Integer> diferencia = conjuntoA.diferencia(conjuntoB);
        System.out.println("Diferencia de A y B: " + diferencia);         
        System.out.println("¿A es un subconjunto de B? " + conjuntoA.esSubConjunto(conjuntoB));         
        System.out.println("¿A y B son iguales? " + conjuntoA.equals(conjuntoB));
    }
}

