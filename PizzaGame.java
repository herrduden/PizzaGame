import javax.swing.JFrame;

public class PizzaGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Infinite Pizza");
        GamePanel gamePanel = new GamePanel();
        
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        
        gamePanel.startGame();
    }
}
