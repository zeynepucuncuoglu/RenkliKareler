import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardPanel extends JPanel {
    private Grid grid;
    private JLabel[][] cells;
    private boolean isPlayable;
    private Game game;

    public BoardPanel(Grid grid, Game game, boolean isPlayable) {
        this.grid = grid;
        this.game = game;
        this.isPlayable = isPlayable;
        this.setLayout(new GridLayout(grid.getSize(), grid.getSize()));
        cells = new JLabel[grid.getSize()][grid.getSize()];

        for (int i = 0; i < grid.getSize(); i++) {
            for (int j = 0; j < grid.getSize(); j++) {
                cells[i][j] = new JLabel();
                cells[i][j].setOpaque(true);
                cells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                cells[i][j].setBackground(Color.WHITE);
                final int row = i;
                final int col = j;
                if (isPlayable) {
                    cells[i][j].addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            toggleCellColor(row, col);
                        }
                    });
                }
                this.add(cells[i][j]);
            }
        }
        updateGrid();
    }

    public void updateGrid() {
        for (int i = 0; i < grid.getSize(); i++) {
            for (int j = 0; j < grid.getSize(); j++) {
                updateCellColor(i, j);
            }
        }
    }

    private void toggleCellColor(int row, int col) {
        char currentColor = grid.getCell(row, col);
        if (currentColor == 'R') {
            grid.setCell(row, col, 'B');
        } else {
            grid.setCell(row, col, 'R');
        }
        updateCellColor(row, col);
    }

    private void updateCellColor(int row, int col) {
        char cellValue = grid.getCell(row, col);
        if (cellValue == 'R') {
            cells[row][col].setBackground(Color.RED);
        } else if (cellValue == 'B') {
            cells[row][col].setBackground(Color.BLUE);
        } else {
            cells[row][col].setBackground(Color.WHITE);
        }
    }
}
