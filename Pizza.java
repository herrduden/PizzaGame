import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class Pizza {
    private int x, y;
    private int dy;

    public Pizza(int x, int y) {
        this.x = x;
        this.y = y;
        this.dy = 0;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void move() {
        y += dy;
        if (y < 0) y = 0;
        if (y > 550) y = 550; // Assuming game height is 600
    }

    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillOval(x, y, 50, 50);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 50);
    }
}
