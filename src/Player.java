import java.awt.*;

public class Player{
    static double xSpeed = 0;
    static double ySpeed = 0;
    static int x = 300;
    static int y = 300;
    static double velocity = 0.1;
    public static int playerSize = 40;

    //Method for creating Player and movement
    public static void playerBall(Graphics2D g2) {

        x = (int) (x + xSpeed);
        y = (int) (y + ySpeed);

        xSpeed = (GamePanel.mouseLocation.x - x) * velocity;
        ySpeed = (GamePanel.mouseLocation.y - y) * velocity;

        g2.setColor(Color.red);
        g2.fillOval(x - 20, y - 20, playerSize, playerSize);

    }

}
