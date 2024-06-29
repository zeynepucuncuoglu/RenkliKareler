public class Grid {
    private char[][] grid;
    private static final int SIZE = 6;

    public Grid() {
        grid = new char[SIZE][SIZE];
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setCell(int row, int col, char color) {
        grid[row][col] = color;
    }

    public char getCell(int row, int col) {
        return grid[row][col];
    }

    public int getSize() {
        return SIZE;
    }
}
