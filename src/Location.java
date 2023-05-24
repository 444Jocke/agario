import java.awt.*;

public class Location {

    private Point position;

    public void mouseLocation() {
        position = new Point();
    }

    public void updatePosition(Point newPosition) {
        position = newPosition;
    }

    public Point getPosition() {
        return position;
    }
}



