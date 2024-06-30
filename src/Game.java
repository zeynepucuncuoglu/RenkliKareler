import java.util.Arrays;

public class Game {
    public enum Difficulty {
        SIMPLE, MEDIUM, HARD
    }

    private Grid playGrid;
    private Grid solutionGrid;
    private Solver solver;
    private Difficulty difficulty;
    private int score;

    public Game() {
        playGrid = new Grid();
        solutionGrid = new Grid();
        solver = new Solver();
        this.difficulty = Difficulty.SIMPLE;
        startNewGame();
        this.score = 0;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void startNewGame() {
        solver.generatePuzzle(playGrid, solutionGrid, difficulty);
    }

    public Grid getPlayGrid() {
        return playGrid;
    }

    public Grid getSolutionGrid() {
        return solutionGrid;
    }

    public boolean isCompleted() {
        return Arrays.deepEquals(playGrid.getGrid(), solutionGrid.getGrid());
    }

    public boolean isValidSolution() {
        return solver.isValidGrid(playGrid.getGrid());
    }

    public void updateSolutionWithUserGrid() {
        for (int i = 0; i < playGrid.getSize(); i++) {
            for (int j = 0; j < playGrid.getSize(); j++) {
                solutionGrid.setCell(i, j, playGrid.getCell(i, j));
            }
        }
    }
}
