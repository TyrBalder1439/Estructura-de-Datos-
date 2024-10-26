import java.util.Stack;
public class PilaMediaRecursiva {
    public static int obtenerElementoMedio(Stack<Integer> pila, int posicionMedia) {
        if (posicionMedia == 0) {
            return pila.pop();
        }
        int elemento = pila.pop();
        int resultado = obtenerElementoMedio(pila, posicionMedia - 1);
        pila.push(elemento);
        return resultado;
    }
}
