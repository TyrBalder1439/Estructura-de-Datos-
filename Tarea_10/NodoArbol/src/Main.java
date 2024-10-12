public class Main {
    public static void main(String[] args) {
        System.out.println("Tarea de àrboles");
        NodoArbol<String> raiz = new NodoArbol<>("10");
        raiz.setHijoIzquierdo(new NodoArbol<>("5"));
        raiz.setHijoDerecho(new NodoArbol<>("15"));
        raiz.getHijoDerecho().setHijoDerecho(new NodoArbol<>("25"));
        raiz.getHijoIzquierdo().setHijoIzquierdo(new NodoArbol<>("1"));
        System.out.println(raiz);
        System.out.println("---------------------en una sola linea de codigo-----------------------------");
        NodoArbol<String> raiz2 = new NodoArbol<>
                ("Diego",new NodoArbol<>("Pedro",new NodoArbol<>("Susana"),new NodoArbol<>("Diana")),new NodoArbol<>("Mario"));
        System.out.println(raiz2);

    }
}