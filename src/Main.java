
import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {

        //creates JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);

        //creates GamePanel
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.pack();
        //the window will be in the centre of the screen
        frame.setLocationRelativeTo(null);

        gamePanel.startGameThread();


    }

}