package dinosaur;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

import utils.KeyboardUtil;
import utils.MouseUtil;

public class Dinosaur {
    private static final int[] cactiPosition = new int[]{828, 258};
    private static final int[] pterosaurPosition = new int[]{828, 230};
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
                        if (  mRobot.getPixelColor(cactiPosition[0], cactiPosition[1]).equals(cactiColor)) {
                            System.out.println("jump");
                            keyboardUtil.instantInput(KeyEvent.VK_SPACE);
                        }
//                        else if ( mRobot.getPixelColor(cactiPosition[0], cactiPosition[1]).equals(emptyColor)&&
//                                mRobot.getPixelColor(pterosaurPosition[0],pterosaurPosition[1]).equals(cactiColor)){
//                            System.out.println("down");
//                            keyboardUtil.instantInput(KeyEvent.VK_DOWN);
//                        }
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
