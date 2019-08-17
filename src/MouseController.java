
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
public class MouseController {
    public static final int xPos1 = 100, xPos2 = 200, xPos3 = 300, xPos4 = 400;
    public static final int yPos1 = 100, yPos2 = 200, yPos3 = 300, yPos4 = 400;
    static int x, y = 0;
    public static void main(String[] args) throws Exception{
        int row = 1;
        switch(row) {
            case 1:
                x = xPos1;
            case 2:
                x = xPos2;
            case 3:
                x = xPos3;
            case 4:
                x = xPos4;
        }
        int column = 1;
        switch(column ) {
            case 1:
                y = yPos1;
            case 2:
                y = yPos2;
            case 3:
                y = yPos3;
            case 4:
                y = yPos4;
        }



        Robot robot = new Robot();

        robot.mouseMove(x, y);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}
