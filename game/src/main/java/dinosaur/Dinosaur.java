package dinosaur;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

import utils.KeyboardUtil;
import utils.MouseUtil;

public class Dinosaur {
    private static final int[] cactiPosition = new int[]{815, 253};
    private static final int[] cactiPosition1 = new int[]{800, 253};
    private static final int[] cactiPosition2 = new int[]{790, 253};
    private static final int[] pterosaurPosition = new int[]{820, 225};
    private static final int[] pterosaurPosition1 = new int[]{815, 225};
    private static final Color cactiColor = new Color(83, 83, 83);
    private static final Color emptyColor = new Color(255, 255, 255);

    public static void main(String[] args) {

        try {
            Robot mRobot = new Robot();
            Random random = new Random();
            MouseUtil mouseUtil = new MouseUtil();
            KeyboardUtil keyboardUtil = new KeyboardUtil();
            mRobot.delay(5000);
            System.out.println("location:  " + mouseUtil.getMousePositionString());
            System.out.println("location:  " + mRobot.getPixelColor(959, 254));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (mRobot.getPixelColor(cactiPosition[0], cactiPosition[1]).equals(cactiColor)) {
                            System.out.println("jump");
                            keyboardUtil.instantInput(KeyEvent.VK_SPACE);
                        } else if (mRobot.getPixelColor(cactiPosition1[0], cactiPosition1[1]).equals(cactiColor)) {
                            System.out.println("second jump");
                            keyboardUtil.instantInput(KeyEvent.VK_SPACE);
                        }else if (mRobot.getPixelColor(cactiPosition2[0], cactiPosition2[1]).equals(cactiColor)) {
                            System.out.println("third jump");
                            keyboardUtil.instantInput(KeyEvent.VK_SPACE);
                        }  else if (mRobot.getPixelColor(pterosaurPosition[0], pterosaurPosition[1]).equals(cactiColor)) {
                            System.out.println("down");
                            keyboardUtil.instantInput(KeyEvent.VK_DOWN);
                        }else if (mRobot.getPixelColor(pterosaurPosition1[0], pterosaurPosition1[1]).equals(cactiColor)) {
                            System.out.println("second down");
                            keyboardUtil.instantInput(KeyEvent.VK_DOWN);
                        }
//                        try {
//                            Thread.sleep(30);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                }
            }).start();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
