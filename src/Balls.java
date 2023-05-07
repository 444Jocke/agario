import java.awt.*;
import javax.swing.JPanel;
import java.awt.*;

public class Balls extends GamePanel{

    static GamePanel gp;

    static double xSpeed = 0;
    static double ySpeed = 0;
    static int x = 300;
    static int y = 300;



    static double velocity = 0.1;


    @Override
    public void run() {

        while(gameThread != null) {

            update();
            repaint();
            System.out.println("Mouse location: " + mouseLocation.x + ", " + mouseLocation.y);
            try {
                Thread.sleep(16); // Wait for 1/60th of a second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }




    public static void draw(Graphics2D g2) {

        x = (int) (x + xSpeed);
        y = (int) (y + ySpeed);

        xSpeed = (mouseLocation.x - x) * velocity;
        ySpeed = (mouseLocation.y - y) * velocity;

        g2.setColor(Color.red);
        g2.fillOval(x - 20, y - 20, 40, 40);


    }

}
