import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class GamePanel extends JPanel implements Runnable{
    Thread gameThread;
    public static Point mouseLocation = new Point();

    public GamePanel(){

        //setting panel properties
        this.setPreferredSize(new Dimension(600, 600));
        this.setBackground(Color.WHITE);

        //gives the mlocation of the mouse to the mouseLocation
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseLocation = e.getPoint();
            }
        });
    }
    //starts the game thread and updates the graphics
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {

        while(gameThread != null) {
            repaint();
        }
    }
    //creates the graphics on screen
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Text.drawText(g2);
        Balls.Player(g2);
        Balls.Food(g2);
    }




}