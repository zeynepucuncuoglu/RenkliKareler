import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private GameUI gameUI;

    public ControlPanel(GameUI gameUI) {
        this.gameUI = gameUI;
        this.setLayout(new BorderLayout());

        JButton newGameButton = new JButton("Yeni Oyun");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameUI.startNewGame();
            }
        });

        JButton checkSolutionButton = new JButton("Bitir");
        checkSolutionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameUI.checkSolution();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(newGameButton);
        buttonPanel.add(checkSolutionButton);

        this.add(buttonPanel, BorderLayout.NORTH);

        JLabel descriptionLabel = new JLabel("<html>Boş karelerin tümünü kirmizi ve mavi renklerle öyle boyayiniz ki: Her sirada ve kolonda eşit sayida kirmizi ve mavi kare bulunsun. Hiçbir sirada ve kolonda ayni renkli 3 kare yan yana bulunmasin. Aşağıdan zorluk derecesiz seçiniz </html>");
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(descriptionLabel, BorderLayout.CENTER);

        JPanel difficultyPanel = new JPanel();
        difficultyPanel.setLayout(new GridLayout(1, 3));

        JButton simpleButton = new JButton("Basit");
        simpleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameUI.setDifficulty(Game.Difficulty.SIMPLE);
            }
        });

        JButton mediumButton = new JButton("Orta");
        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameUI.setDifficulty(Game.Difficulty.MEDIUM);
            }
        });

        JButton hardButton = new JButton("Zor");
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameUI.setDifficulty(Game.Difficulty.HARD);
            }
        });

        difficultyPanel.add(simpleButton);
        difficultyPanel.add(mediumButton);
        difficultyPanel.add(hardButton);

        this.add(difficultyPanel, BorderLayout.SOUTH);
    }
}
