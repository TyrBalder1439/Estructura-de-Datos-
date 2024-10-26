import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        pila.push(110);
        pila.push(56);
        pila.push(31);
        pila.push(94);
        pila.push(28);
        pila.push(26);
        pila.push(56);
        pila.push(684);
        pila.push(45);
        System.out.println("la pila es: "+ pila);
        int posicionMedia = pila.size() / 2;
        int valorMedia = PilaMediaRecursiva.obtenerElementoMedio(pila, posicionMedia);
        System.out.println("El valor en la posición media es: " + valorMedia);
        System.out.println("La pila es: "+ pila);
    }
}
