import java.awt.*;

public class Location {
    static Point p = MouseInfo.getPointerInfo().getLocation();
    static int x = p.x;
    static int y = p.y;

    private double xSpeed = 0;
    private double ySpeed = 0;

    public void movement() {

        x = (int) (x + xSpeed);
        y = (int) (y + ySpeed);

        double velocity = 0.1;
        xSpeed = (x) * velocity;
        ySpeed = (y) * velocity;


    }



    public void gogs(){

        System.out.println(x + ", " + y);

    }




}










