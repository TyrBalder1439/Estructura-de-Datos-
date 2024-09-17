public class Array2d {
    private int[][] grid;

    public Array2d(int rows, int cols) {
        grid = new int[rows][cols];
    }

    public int get(int row, int col) {
        return grid[row][col];
    }

    public void set(int row, int col, int value) {
        grid[row][col] = value;
    }

    public int getRows() {
        return grid.length;
    }

    public int getCols() {
        return grid[0].length;
    }

    // Métodos adicionales según sea necesario
}
