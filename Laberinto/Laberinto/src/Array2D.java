public class Array2D {
    private int[][] array;

    public Array2D(int filas, int columnas) {
        array = new int[filas][columnas];
    }

    public int getValor(int fila, int columna) {
        return array[fila][columna];
    }

    public void setValor(int fila, int columna, int valor) {
        array[fila][columna] = valor;
    }

    public int getFilas() {
        return array.length;
    }

    public int getColumnas() {
        return array[0].length;
    }

    public void mostrarArray() {
        for (int[] fila : array) {
            for (int celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }
}

