import java.awt.*;

public class Rectangle extends Shape {
    protected int width, height;

    public Rectangle() {
        super();
        this.width = 10;
        this.height = 10;
    }

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g, Color c) {
        g.setColor(c);
        g.fillRect(x, y, width, height);
    }
}
