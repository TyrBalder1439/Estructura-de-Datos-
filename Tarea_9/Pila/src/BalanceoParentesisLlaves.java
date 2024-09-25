public class BalanceoParentesisLlaves {

    public static boolean estaBalanceado(String texto) {
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c == '{' || c == '(') {
                pila.push(c);
            } else if (c == '}' || c == ')') {
                if (pila.isEmpty()) {
                    return false; 
                }
                char tope = pila.peek();
                if ((c == '}' && tope != '{') || (c == ')' && tope != '(')) {
                    return false;
                }
                pila.pop();
            }
        }

        return pila.isEmpty();
    }

    public static void main(String[] args) {
        String textoDePrueba1 = "{(())}";
        String textoDePrueba2 = "{(})";

        System.out.println("Texto 1: {(())} " + (estaBalanceado(textoDePrueba1) ? " Balanceado" : "No balanceado"));
        System.out.println("Texto 2: {(}) " + (estaBalanceado(textoDePrueba2) ? " Balanceado" : "No balanceado"));
    }
}
