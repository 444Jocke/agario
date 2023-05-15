import java.awt.*;
import java.util.Random;

public class Food extends GamePanel{


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
    //checks for collision
    private static boolean collision(int foodX, int foodY) {
        int playerRadius = 20;
        int foodRadius = 5;
        int area = (Player.x - foodX) * (Player.x - foodX) + (Player.y - foodY) * (Player.y - foodY);
        int collisionArea = (playerRadius + foodRadius) * (playerRadius + foodRadius);
        return area <= collisionArea;
    }
    //draws the food in the panel and handles collision
    public static void Foods(Graphics2D g2) {
        g2.setColor(Color.green);
        for (Point pos : foods) {
            if (pos != null) {
                // Draw the food item on the screen
                g2.fillOval(pos.x, pos.y, 10, 10);


                //collison check
                if (collision(pos.x, pos.y)) {
                    Player.playerSize++;
                    // Food gets teleported out of sight when touched
                    pos.setLocation(1000, 1000);
                }
            }
        }
    }
}
