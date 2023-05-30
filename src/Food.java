import java.awt.*;
import java.util.Random;

public class Food {
    private static final Point[] foods;

    static {
        foods = generateFoodPositions();
    }

    private static Point[] generateFoodPositions() {
        Random rand = new Random();
        Point[] positions = new Point[4];
        for (int i = 0; i < positions.length; i++) {
            int randomX = rand.nextInt(599);
            int randomY = rand.nextInt(599);
            positions[i] = new Point(randomX, randomY);
        }
        return positions;
    }

    private static boolean collision(int foodX, int foodY, Player player) {
        int playerRadius = 25;
        int foodRadius = 5;
        int area = (player.getX() - foodX) * (player.getX() - foodX) + (player.getY() - foodY) * (player.getY() - foodY);
        int collisionArea = (playerRadius + foodRadius) * (playerRadius + foodRadius);
        return area <= collisionArea;
    }

    public void drawFoods(Graphics2D g2, Player player) {
        g2.setColor(Color.green);
        for (Point pos : foods) {
            if (pos != null) {
                g2.fillOval(pos.x, pos.y, 10, 10);
                if (collision(pos.x, pos.y, player)) {
                    player.increasePlayerSize();
                    pos.setLocation(1000, 1000);
                }
            }
        }
    }
}