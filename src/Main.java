//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Game game = new Game();
                GameUI gameUI = new GameUI(game);
                gameUI.createAndShowGUI();
            }
        });
    }
}
