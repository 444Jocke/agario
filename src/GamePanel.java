import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class GamePanel extends JPanel implements Runnable{
    Thread gameThread;
    double xSpeed = 0;
    double ySpeed = 0;
    int x = 300;
    int y = 300;

    double velocity = 0.1;

    private Point mouseLocation = new Point();

    public GamePanel(){

        this.setPreferredSize(new Dimension(600, 600));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseLocation = e.getPoint();
            }
        });
    }
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

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
    public void update(){

    }
public void paintComponent(Graphics g) {

    x = (int) (x + xSpeed);
    y = (int) (y + ySpeed);

    xSpeed = (mouseLocation.x - x) * velocity;
    ySpeed = (mouseLocation.y - y) * velocity;


    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    g2.setColor(Color.red);
    g2.fillOval(x - 20, y - 20, 40, 40);
    g2.dispose();
    }
}