import java.awt.*;

public class Player {

    /*
    private int x = 300;

    private int y = 300;
     */
    Location loc= new Location();

    private int playerSize = 40;
    private Point mouseLocation;



    public void setMouseLocation(Point mouseLocation) {
        this.mouseLocation = mouseLocation;
    }

    public int getX() {
        return loc.x;
    }

    public int getY() {
        return loc.y;
    }

    public void increasePlayerSize() {
        playerSize++;
        Text.increaseScore(1);
    }

    public void drawPlayer(Graphics2D g2) {

        loc.movement();
        g2.setColor(Color.red);

        g2.fillOval(Location.x, Location.y, playerSize, playerSize);
    }
}