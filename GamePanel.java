import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Pizza pizza;
    private ArrayList<Obstacle> obstacles;
    private Timer timer;
    private boolean gameOver;
    
    public GamePanel() {
        pizza = new Pizza(100, 300);
        obstacles = new ArrayList<>();
        timer = new Timer(20, this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        gameOver = false;
    }
    
    public void startGame() {
        timer.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            pizza.move();
            updateObstacles();
            checkCollisions();
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameOver) {
            g.setColor(Color.RED);
            g.drawString("Game Over!", 350, 250);
        } else {
            pizza.draw(g);
            for (Obstacle obstacle : obstacles) {
                obstacle.draw(g);
            }
        }
    }

    private void updateObstacles() {
        if (new Random().nextInt(100) < 2) { // Chance to generate a new obstacle
            obstacles.add(new Obstacle(800, new Random().nextInt(550)));
        }
        
        ArrayList<Obstacle> toRemove = new ArrayList<>();
        for (Obstacle obstacle : obstacles) {
            obstacle.move();
            if (obstacle.getX() < 0) {
                toRemove.add(obstacle);
            }
        }
        obstacles.removeAll(toRemove);
    }

    private void checkCollisions() {
        for (Obstacle obstacle : obstacles) {
            if (pizza.getBounds().intersects(obstacle.getBounds())) {
                gameOver = true;
                timer.stop();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            pizza.setDy(-5);
        } else if (code == KeyEvent.VK_DOWN) {
            pizza.setDy(5);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pizza.setDy(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
