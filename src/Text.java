import java.awt.*;

public class Text{
    static int textX = 200;
    static int textY = 100;

    private static int score = 0;
    private static final String text = "Move mouse to control player and get all the balls!";

    public static void increaseScore(int points) {

        score += points;
    }


    //draws text on panel
    public static void drawText(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.drawString(text, textX, textY);
        g2.drawString("Score: " + score , 30,30);
    }


}


