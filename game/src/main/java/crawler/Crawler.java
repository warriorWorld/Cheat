package crawler;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

import utils.KeyboardUtil;
import utils.MouseUtil;

public class Crawler {
    private static final Color unLoadedColor = new Color(31, 31, 31);
    private static final Color unLoadedColor1 = new Color(13, 13, 13);
    private static final Color confirmColor = new Color(51, 54, 57);
    private static final int[] imgPosition = new int[]{1156, 746};
    private static final int[] savePosition = new int[]{1199, 633};
    private static final int[] confirmPosition = new int[]{772, 506};

    public static void main(String[] args) {

        try {
            Robot mRobot = new Robot();
            Random random = new Random();
            MouseUtil mouseUtil = new MouseUtil();
            KeyboardUtil keyboardUtil = new KeyboardUtil();
            mRobot.delay(3000);
            System.out.println("location:  " + mouseUtil.getMousePositionString());
            System.out.println("location:  " + mRobot.getPixelColor(772, 506));
            for (int i = 0; i < 20; i++) {
                if (!mRobot.getPixelColor(imgPosition[0], imgPosition[1]).equals(unLoadedColor) &&
                        !mRobot.getPixelColor(imgPosition[0], imgPosition[1]).equals(unLoadedColor1)) {
                    mouseUtil.delayMove(imgPosition);
                    mouseUtil.delayClickRight();
                    mouseUtil.delayMove(savePosition);
                    mouseUtil.delayClick();
                    mouseUtil.delayMove(confirmPosition);
                    while (true) {
                        mRobot.delay(1000);
                        Color resultColor=mRobot.getPixelColor(confirmPosition[0], confirmPosition[1]);
                        System.out.println("result color"+resultColor);
                        if (resultColor.equals(confirmColor)) {
                            System.out.println("click");
                            mouseUtil.delayClick();
                            mouseUtil.delayMove(imgPosition);
                            mouseUtil.delayClick();
                            break;
                        }else {
                            System.out.println("unsame");
                        }
                    }
                }
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
