import java.awt.*;
import java.util.Random;

public class Balls extends GamePanel{
    static double xSpeed = 0;
    static double ySpeed = 0;
    static int x = 300;
    static int y = 300;
    static double velocity = 0.1;
    static int playerSize = 40;
    private static final Point[] foods;

    static {
        // Generate random positions for the food items
        Random rand = new Random();
        foods = new Point[40];
        for (int i = 0; i < foods.length; i++) {
            int randomX = rand.nextInt(599);
            int randomY = rand.nextInt(599);
            foods[i] = new Point(randomX, randomY);
        }
    }
    //draw player on panel
    public static void Player(Graphics2D g2) {

        x = (int) (x + xSpeed);
        y = (int) (y + ySpeed);

        xSpeed = (mouseLocation.x - x) * velocity;
        ySpeed = (mouseLocation.y - y) * velocity;

        g2.setColor(Color.red);
        g2.fillOval(x - 20, y - 20, playerSize, playerSize);

    }
    //checks for collision
    private static boolean collision(int foodX, int foodY) {
        int playerRadius = 20;
        int foodRadius = 5;
        int area = (x - foodX) * (x - foodX) + (y - foodY) * (y - foodY);
        int collisionArea = (playerRadius + foodRadius) * (playerRadius + foodRadius);
        return area <= collisionArea;
    }
    //draws the food in the panel and handles collision
    public static void Food(Graphics2D g2) {
        g2.setColor(Color.green);
        for (Point pos : foods) {
            if (pos != null) {
                // Draw the food item on the screen
                g2.fillOval(pos.x, pos.y, 10, 10);


                //collison check
                if (collision(pos.x, pos.y)) {
                    playerSize++;
                    // Food gets teleported out of sight when touched
                    pos.setLocation(1000, 1000);
                }
            }
        }
    }
}
