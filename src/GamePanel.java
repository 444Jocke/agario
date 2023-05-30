import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class GamePanel extends JPanel implements Runnable {
    private Thread gameThread;
    private final Player player;
    private final Food food;

    public GamePanel() {
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.WHITE);

        player = new Player();
        food = new Food();

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                player.setMouseLocation(e.getPoint());
            }
        });
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) {
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Text.drawText(g2);
        player.drawPlayer(g2);
        food.drawFoods(g2, player);
    }
}