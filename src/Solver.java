import java.util.Random;

public class Solver {
    private static final char RED = 'R';
    private static final char BLUE = 'B';
    private static final int SIZE = 6;
    private Random random = new Random();

    public void generatePuzzle(Grid playGrid, Grid solutionGrid, Game.Difficulty difficulty) {
        char[][] solution = new char[SIZE][SIZE];
        fillGrid(solution);

        int filledCells;
        switch (difficulty) {
            case SIMPLE:
                filledCells = 18;
                break;
            case MEDIUM:
                filledCells = 12;
                break;
            case HARD:
                filledCells = 9;
                break;
            default:
                filledCells = 18;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                solutionGrid.setCell(i, j, solution[i][j]);
                playGrid.setCell(i, j, '\0');
            }
        }
        for (int k = 0; k < filledCells; k++) {
            int row, col;
            do {
                row = random.nextInt(SIZE);
                col = random.nextInt(SIZE);
            } while (playGrid.getCell(row, col) != '\0');
            playGrid.setCell(row, col, solution[row][col]);
        }
    }

    private void fillGrid(char[][] grid) {
        while (true) {
            for (int i = 0; i < SIZE; i++) {
                int redCount = 0, blueCount = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (redCount < 3 && (blueCount == 3 || random.nextBoolean())) {
                        grid[i][j] = RED;
                        redCount++;
                    } else {
                        grid[i][j] = BLUE;
                        blueCount++;
                    }
                }
            }

            if (isValidGrid(grid)) {
                break;
            }
        }
    }

    private boolean isValidGrid(char[][] grid) {
        for (int i = 0; i < SIZE; i++) {
            if (!isValidLine(grid[i])) {
                return false;
            }

            char[] column = new char[SIZE];
            for (int j = 0; j < SIZE; j++) {
                column[j] = grid[j][i];
            }
            if (!isValidLine(column)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidLine(char[] line) {
        int redCount = 0, blueCount = 0;

        for (int i = 0; i < SIZE; i++) {
            if (line[i] == RED) {
                redCount++;
                if (i > 1 && line[i - 1] == RED && line[i - 2] == RED) {
                    return false;
                }
            } else if (line[i] == BLUE) {
                blueCount++;
                if (i > 1 && line[i - 1] == BLUE && line[i - 2] == BLUE) {
                    return false;
                }
            }
        }

        return redCount == 3 && blueCount == 3;
    }
}
