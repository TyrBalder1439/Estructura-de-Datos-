public class Main {
    public static void main(String[] args) {
        GameOfLife game = new GameOfLife(8, 8);  // Crear un juego con una rejilla de 5x5

        int generations = 10;  // Número de generaciones a calcular
        for (int i = 0; i < generations; i++) {
            System.out.println("Generación " + (i + 1) + ":");
            game.printGrid();
            game.nextGeneration();
        }
    }
}