import java.awt.*;
import java.util.Random;

public class Balls extends GamePanel{

    static GamePanel gp;
    static double xSpeed = 0;
    static double ySpeed = 0;
    static int x = 300;
    static int y = 300;
    static double velocity = 0.1;

    // Add this field to hold the positions of the food items
    private static Point[] foodPositions;

    static {
        // Generate random positions for the food items
        Random rand = new Random();
        foodPositions = new Point[40];
        for (int i = 0; i < foodPositions.length; i++) {
            int randomX = rand.nextInt(599);
            int randomY = rand.nextInt(599);
            foodPositions[i] = new Point(randomX, randomY);
        }
    }

    public static void Player(Graphics2D g2) {

        x = (int) (x + xSpeed);
        y = (int) (y + ySpeed);

        xSpeed = (mouseLocation.x - x) * velocity;
        ySpeed = (mouseLocation.y - y) * velocity;

        g2.setColor(Color.red);
        g2.fillOval(x - 20, y - 20, 40, 40);

    }

    public static void Food(Graphics2D g2) {
        // Draw the food items using the fixed positions generated earlier
        g2.setColor(Color.green);
        for (Point pos : foodPositions) {
            g2.fillOval(pos.x, pos.y, 10, 10);
        }
    }

}
