import java.awt.*;

public class Text extends GamePanel {
    static int textX = 200;
    static int textY = 100;
    private static final String text = "Move mouse to control player and get all the balls";


    //draws text on panel
    public static void drawText(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.drawString(text, textX, textY);
    }
}


