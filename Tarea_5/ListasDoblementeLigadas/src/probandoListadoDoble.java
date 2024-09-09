public class probandoListadoDoble {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> lista = new DoubleLinkedList<>();

        lista.agregarAlInicio(50);

        lista.agregarAlFinal(60);
        lista.agregarAlFinal(65);
        lista.agregarAlFinal(70);
        lista.agregarAlFinal(80);
        lista.agregarAlFinal(90);
        System.out.print("Contenido de la lista: ");
        lista.transversal(0);
        lista.eliminar(2);
        System.out.print("Contenido después de eliminar la posición 2: ");
        lista.transversal(0);
        lista.actualizar(lista.obtener(3), 88);
        System.out.print("actualizar el cuarto elemento a 88: ");
        lista.transversal(0);
        int posicion = lista.buscar(80);
        System.out.println("El valor 80 se encuentra en la posición: " + posicion);
    }
}
