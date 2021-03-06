package utils;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MouseUtil {
    private Robot mRobot;
    private Random mRandom;

    public MouseUtil() throws AWTException {
        mRobot = new Robot();
        mRandom = new Random();
    }

    public int[] getMousePosition() {
        PointerInfo pinfo = MouseInfo.getPointerInfo();
        Point p = pinfo.getLocation();
        double mx = p.getX();
        double my = p.getY();

        return new int[]{(int) mx, (int) my};
    }

    public String getMousePositionString() {
        int[] result = getMousePosition();
        return result[0] + "," + result[1];
    }

    public void delayClick() {
        mRobot.delay(200 + mRandom.nextInt(150));
        mRobot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        mRobot.delay(200 + mRandom.nextInt(150));
        mRobot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
    }

    public void delayClickRight() {
        mRobot.delay(200 + mRandom.nextInt(150));
        mRobot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
        mRobot.delay(200 + mRandom.nextInt(150));
        mRobot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
    }

    public void delayMove(int[] position) {
        mRobot.delay(200 + mRandom.nextInt(150));
        mRobot.mouseMove(position[0], position[1]);
    }
}
