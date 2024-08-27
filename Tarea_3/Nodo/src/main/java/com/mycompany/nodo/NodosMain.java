package com.mycompany.nodo;

public class NodosMain {
    public static void main(String[] args) {
        System.out.println("creando la estructura");
        Nodo<Integer> head2 = new Nodo<>(100,new Nodo<>(200, new Nodo<>(300, new Nodo<>(400, new Nodo <>(600)))) );
        Nodo<Integer> auxi = head2;
        System.out.print("|");
        while (auxi != null){
            System.out.print(auxi.getDato() + "| -> |");
            auxi = auxi.getSiguiente();
        }
        System.out.print("null|\n");
        System.out.println("cambiando 300 por 333");

        head2.getSiguiente().getSiguiente().setDato(333);        
        Nodo<Integer> aux = head2;
        System.out.print("|");
        while (aux != null){
            System.out.print(aux.getDato() + "| -> |");
            aux = aux.getSiguiente();
        }
        System.out.print("null|\n");
        System.out.println("integrando 700 al final");        
        head2.getSiguiente().getSiguiente().getSiguiente().getSiguiente().setSiguiente(new Nodo<>(700));
        Nodo<Integer> aux3 = head2;
        System.out.print("|");
        while (aux3 != null){
            System.out.print(aux3.getDato() + "| -> |");
            aux3 = aux3.getSiguiente();
        }
        System.out.print("null|\n");      
        System.out.println("agregando nuevo nodo al inicio");
        
        head2 = new Nodo<>(50, head2);
        Nodo<Integer> au = head2;
        System.out.print("|");
        while (au != null) {
            System.out.print(au.getDato() + "| -> |");
            au = au.getSiguiente();
        }
        System.out.print("null|\n");
    }
}