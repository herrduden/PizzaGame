import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class Obstacle {
    private int x, y;
    private int width, height;

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 30;
        this.height = 30;
    }

    public void move() {
        x -= 5; // Speed of the obstacle moving towards the pizza
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
