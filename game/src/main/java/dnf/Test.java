package dnf;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Test {
    public static void main(String[] args) {

        try {
            Robot mRobot=new Robot();
            mRobot.keyPress(KeyEvent.VK_K);
            mRobot.mouseMove(30,5);
mRobot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
