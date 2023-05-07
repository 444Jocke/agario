import java.awt.*;
import java.util.Random;

public class Balls extends GamePanel{

    static GamePanel gp;
    static double xSpeed = 0;
    static double ySpeed = 0;
    static int x = 300;
    static int y = 300;
    static double velocity = 0.1;



    public static void Player(Graphics2D g2) {

        x = (int) (x + xSpeed);
        y = (int) (y + ySpeed);

        xSpeed = (mouseLocation.x - x) * velocity;
        ySpeed = (mouseLocation.y - y) * velocity;

        g2.setColor(Color.red);
        g2.fillOval(x - 20, y - 20, 40, 40);

    }

    public static void Food(Graphics2D g2) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int randomX = rand.nextInt(599);
            int randomY= rand.nextInt(599);
            g2.setColor(Color.green);
            g2.fillOval(randomX, randomY, 10, 10);
        }
    }

}



