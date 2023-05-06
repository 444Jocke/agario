import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

public class Movement {
    private static Point mouseLocation = MouseInfo.getPointerInfo().getLocation();

    public static Point getMouseLocation() {
        return mouseLocation;
    }

   public static void startUpdatingMouseLocation() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                mouseLocation = MouseInfo.getPointerInfo().getLocation();
                //System.out.println("Mouse location: " + mouseLocation.x + ", " + mouseLocation.y);
            }
        }, 0, 60); // update every second (1000 milliseconds)
    }
}