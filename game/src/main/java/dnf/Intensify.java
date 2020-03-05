package dnf;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

import utils.MouseUtil;

public class Intensify {
    private static final int continuousSuccessLimit = 3;
    private static int continuousSuccessCount = 0;
    private static int failedCount = 0;
    private static final int[] inventory1 = new int[]{871, 503};
    private static final int[] inventory2 = new int[]{917, 508};
    private static final int[] inventory3 = new int[]{936, 500};
    private static final int[] intensifyBtnPosition = new int[]{664, 572};
    private static final int[] confirmPosition = new int[]{774, 608};
    private static final int[] confirm2Position = new int[]{798, 562};
    private static final int[] intensifyResutPosition = new int[]{791, 489};
    private static final Color failedColor = new Color(194, 194, 194);
    private static final Color successColor = new Color(255, 255, 195);

    public static void main(String[] args) {

        try {
            Robot mRobot = new Robot();
            Random random = new Random();
            MouseUtil mouseUtil = new MouseUtil();
            mRobot.delay(5000);
//            System.out.println("location:  " + mouseUtil.getMousePositionString());
//            System.out.println("location:  " + mRobot.getPixelColor(intensifyResutPosition[0], intensifyResutPosition[1]));
            for (int i = 0; i < 500; i++) {
                mouseUtil.delayMove(intensifyBtnPosition);
                mouseUtil.delayClick();
                mouseUtil.delayMove(inventory1);
                mouseUtil.delayClick();
                mouseUtil.delayMove(confirmPosition);
                mouseUtil.delayClick();
                mRobot.delay(8000);
                Color resultColor = mRobot.getPixelColor(intensifyResutPosition[0], intensifyResutPosition[1]);
                System.out.println("resultColor :" + resultColor);
                if (resultColor.equals(successColor)) {
                    continuousSuccessCount++;
                    System.out.println("success :" + continuousSuccessCount);
                    if (continuousSuccessCount >= continuousSuccessLimit) {
                        System.out.println("success for intensify!!!");
                        return;
                    }
                } else {
                    failedCount++;
                    System.out.println("failed :" + failedCount);
                    continuousSuccessCount = 0;
                }
                mouseUtil.delayMove(confirm2Position);
                mouseUtil.delayClick();
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}