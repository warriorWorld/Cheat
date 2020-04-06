package test;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import utils.KeyboardUtil;

public class Test {
    /**
     * 读取一张图片的RGB值
     *
     * @throws Exception
     */
    public int[] getImagePixel(String image) throws Exception {
        int[] rgb = new int[3];
        File file = new File(image);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int width = bi.getWidth();
        int height = bi.getHeight();
        int minx = bi.getMinX();
        int miny = bi.getMinY();
        System.out.println("width=" + width + ",height=" + height + ".");
        System.out.println("minx=" + minx + ",miniy=" + miny + ".");
        for (int i = minx; i < width; i++) {
            for (int j = miny; j < height; j++) {
                int pixel = bi.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字
                rgb[0] = (pixel & 0xff0000) >> 16;
                rgb[1] = (pixel & 0xff00) >> 8;
                rgb[2] = (pixel & 0xff);
                System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + ","
                        + rgb[1] + "," + rgb[2] + ")");
            }
        }
        return rgb;
    }

    /**
     * 返回屏幕色彩值
     *
     * @param x
     * @param y
     * @return
     * @throws AWTException
     */
    public int getScreenPixel(int x, int y) throws AWTException { // 函数返回值为颜色的RGB值。
        Robot rb = null; // java.awt.image包中的类，可以用来抓取屏幕，即截屏。
        rb = new Robot();
        Toolkit tk = Toolkit.getDefaultToolkit(); // 获取缺省工具包
        Dimension di = tk.getScreenSize(); // 屏幕尺寸规格
        System.out.println(di.width);
        System.out.println(di.height);
        Rectangle rec = new Rectangle(0, 0, di.width, di.height);
        BufferedImage bi = rb.createScreenCapture(rec);
        int pixelColor = bi.getRGB(x, y);

        return 16777216 + pixelColor; // pixelColor的值为负，经过实践得出：加上颜色最大值就是实际颜色值。
    }

    public static void main(String[] args) {
//        File file = new File("/drawable/loading.png");
//        FileChannel fc = null;
//        if (file.exists() && file.isFile()) {
//            try {
//                FileInputStream fs = new FileInputStream(file);
//                fc = fs.getChannel();
//                System.out.println(fc.size() + "-----fc.size()");
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(file.length() + "-----file.length  B");
//        System.out.println(file.length() * 1024 + "-----file.length  kb");
//        BufferedImage bi = null;
//        try {
//            bi = ImageIO.read(file);
//            Color color = new Color(bi.getRGB(43, 53));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(6);
        arrayList.add(8);

        int repeatTime = 0;
        ArrayList<Integer> temp = arrayList;
        ArrayList<Integer> repeatList = new ArrayList<>();
        while (temp.size() > 1) {
            int item = arrayList.get(0);
            temp.remove(0);
            for (int i = 0; i < temp.size(); i++) {
                repeatTime++;
                if (item == temp.get(i)) {
                    repeatList.add(i);
                }
            }
            if (repeatList.size() > 0) {
                System.out.println("duplicate:" + item);
                for (Integer integer : repeatList) {
                    repeatTime++;
                    temp.remove((int)integer);
                }
                repeatList.clear();
                System.out.println("temp:" + temp);
            }
        }
        System.out.println("repeatTime:" + repeatTime);
    }
}
