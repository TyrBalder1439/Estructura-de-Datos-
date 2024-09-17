public class GameOfLife {
    private Array2d grid;
    private int rows;
    private int cols;

    public GameOfLife(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Array2d(rows, cols);
        initializeGrid();
    }
    private void initializeGrid() {
        grid.set(1, 1, 1);
        grid.set(1, 2, 1);
        grid.set(1, 3, 1);
        grid.set(2, 2, 1);
        grid.set(3, 3, 1);
        grid.set(3, 1, 1);
        grid.set(4, 4, 1);
        grid.set(5, 5, 1);
        grid.set(5, 4, 1);
        grid.set(5, 3, 1);
        grid.set(6, 3, 1);
    }
    public void nextGeneration() {
        Array2d newGrid = new Array2d(rows, cols);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = countLiveNeighbors(row, col);
                if (grid.get(row, col) == 1) {
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        newGrid.set(row, col, 1);
                    } else {
                        newGrid.set(row, col, 0);
                    }
                } else {  // Célula muerta
                    if (liveNeighbors == 3) {
                        newGrid.set(row, col, 1);
                    } else {
                        newGrid.set(row, col, 0);
                    }
                }
            }
        }
        grid = newGrid;
    }
    private int countLiveNeighbors(int row, int col) {
        int liveNeighbors = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;

                int newRow = row + i;
                int newCol = col + j;

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    liveNeighbors += grid.get(newRow, newCol);
                }
            }
        }
        return liveNeighbors;
    }
    public void printGrid() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(grid.get(row, col) + " ");
            }
            System.out.println();
        }
    }
}