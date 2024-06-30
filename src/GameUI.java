import javax.swing.*;
import java.awt.*;

public class GameUI {
    private Game game;
    private JFrame frame;
    private BoardPanel playBoard;
    private BoardPanel solutionBoard;
    private ControlPanel controlPanel;

    public GameUI(Game game) {
        this.game = game;
    }

    public void createAndShowGUI() {
        frame = new JFrame("Renkli Kareler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        playBoard = new BoardPanel(game.getPlayGrid(), game, true);
        solutionBoard = new BoardPanel(game.getSolutionGrid(), game, false);
        controlPanel = new ControlPanel(this);

        JPanel boardPanel = new JPanel(new GridLayout(1, 2, 50, 0));
        boardPanel.add(playBoard);
        boardPanel.add(solutionBoard);

        frame.add(boardPanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public void startNewGame() {
        game.startNewGame();
        playBoard.updateGrid();
        solutionBoard.updateGrid();
    }

    public void checkSolution() {
        if (game.isCompleted()) {
            JOptionPane.showMessageDialog(frame, "Tebrikler! Cevabınız Doğru.", "Success", JOptionPane.INFORMATION_MESSAGE);
            startNewGame();
        } else {
           // Solver solver = new Solver();
            // int solutionCount = solver.countSolutions(game.getPlayGrid());

            if (game.isValidSolution()) {
                JOptionPane.showMessageDialog(frame, "Tebrikler! Cevabınız Doğru.", "Success", JOptionPane.INFORMATION_MESSAGE);
                game.updateSolutionWithUserGrid();
                startNewGame();
            } else {
                JOptionPane.showMessageDialog(frame, "Üzgünüm, cevabınız yanlış. Tekrar deneyiniz", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void setDifficulty(Game.Difficulty difficulty) {
        game.setDifficulty(difficulty);
        startNewGame();
    }
}
