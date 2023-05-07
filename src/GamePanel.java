import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class GamePanel extends JPanel implements Runnable{
    Thread gameThread;
    public static Point mouseLocation = new Point();

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

            //update();
            repaint();
            System.out.println("Mouse location: " + mouseLocation.x + ", " + mouseLocation.y);
            try {
                Thread.sleep(16); // Wait for 1/60th of a second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Balls.Player(g2);

        Balls.Food(g2);






        g2.dispose();
    }
    ////}
}