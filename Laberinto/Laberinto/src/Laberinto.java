public class Laberinto {
    private Array2D laberinto;
    private int[] entrada;
    private int[] salida;
    private Pila<int[]> pila;

    public Laberinto(Array2D laberinto, int[] entrada, int[] salida) {
        this.laberinto = laberinto;
        this.entrada = entrada;
        this.salida = salida;
        this.pila = new Pila<>();
    }

    public boolean resolverLaberinto() {
        pila.push(entrada);
        while (!pila.estaVacia()) {
            int[] posicionActual = pila.peek();
            int fila = posicionActual[0];
            int columna = posicionActual[1];

            laberinto.setValor(fila, columna, 9);

            if (fila == salida[0] && columna == salida[1]) {
                return true;
            }

            if (mover(fila, columna - 1)) {
                pila.push(new int[]{fila, columna - 1});
            } else if (mover(fila - 1, columna)) {
                pila.push(new int[]{fila - 1, columna});
            } else if (mover(fila, columna + 1)) {
                pila.push(new int[]{fila, columna + 1});
            } else if (mover(fila + 1, columna)) {
                pila.push(new int[]{fila + 1, columna});
            } else {
                pila.pop();
            }
        }
        return false;
    }

    private boolean mover(int fila, int columna) {
        return (fila >= 0 && fila < laberinto.getFilas() && columna >= 0 && columna < laberinto.getColumnas() && laberinto.getValor(fila, columna) == 0);
    }

    public void mostrarLaberinto() {
        laberinto.mostrarArray();
    }

    public static Array2D configurarLaberinto(int filas, int columnas) {
        if (filas < 20 || columnas < 20) {
            throw new IllegalArgumentException("El laberinto debe ser al menos de 20x20.");
        }

        Array2D laberinto = new Array2D(filas, columnas);

        int[][] layout = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                laberinto.setValor(i, j, layout[i][j]);
            }
        }

        return laberinto;
    }

    public static void main(String[] args) {
        Array2D laberinto = configurarLaberinto(20, 20);
        int[] entrada = {1, 1};
        int[] salida = {17, 18};

        Laberinto lab = new Laberinto(laberinto, entrada, salida);
        if (lab.resolverLaberinto()) {
            System.out.println("¡Laberinto resuelto!");
        } else {
            System.out.println("No se encontró una solución.");
        }

        lab.mostrarLaberinto();
    }
}