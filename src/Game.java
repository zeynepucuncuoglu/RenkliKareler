import java.util.Arrays;

public class Game {
    public enum Difficulty {
        SIMPLE, MEDIUM, HARD
    }

    private Grid playGrid;
    private Grid solutionGrid;
    private Solver solver;
    private Difficulty difficulty;

    public Game() {
        playGrid = new Grid();
        solutionGrid = new Grid();
        solver = new Solver();
        this.difficulty = Difficulty.SIMPLE;
        startNewGame();
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
}
