package algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by acorn on 2020/5/11.
 */
public class Algorithm {
    public static void main(String[] args) {
        test13();
    }

    /**
     * 打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
     * 例如： 153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
     */
    private static void test1() {
        for (int i = 100; i < 1000; i++) {
            int one = i / 100;
            int two = (i - one * 100) / 10;
            int three = i - one * 100 - two * 10;
            if (Math.pow(one, 3) + Math.pow(two, 3) + Math.pow(three, 3) == i) {
                System.out.println(i + "");
            }
        }
    }

    /**
     * 有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
     */
    private static int[] target = {3, 2, 1, 4};

    private static void test2() {
        int hit = 0;
        int time = 0;
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length; j++) {
                for (int u = 0; u < target.length; u++) {
                    if (target[i] != target[j]
                            && target[i] != target[u]
                            && target[j] != target[u]) {
                        hit++;
                        System.out.println(target[i] + "" + target[j] + "" + target[u] + "\nhit:" + hit);
                    }
                    time++;
                }
            }
        }
        System.out.println("time:" + time);
    }

    /**
     * 输出9*9乘法表
     */
    private static void test3() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.println(i + "*" + j + "=" + i * j);
            }
        }
    }

    /**
     * 猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，
     * 又多吃了一个 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
     * 以后每天早上都吃了前一天 剩下的一半零一个。
     * 到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
     */
    private static void test4() {
        int remainPeach = 1;
        for (int i = 0; i < 11; i++) {
            remainPeach = (remainPeach + 1) * 2;
            System.out.println("result:" + remainPeach);
        }
    }

    /**
     * 题目：判断101-200之间有多少个素数，并输出所有素数。
     * 素数/质数:一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数
     */
    private static void test5() {
        for (int i = 101; i <= 200; i++) {
            boolean isPrimeNum = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrimeNum = false;
                    break;
                }
            }
            if (isPrimeNum) {
                System.out.println("Prime Number:" + i);
            }
        }
    }

    /**
     * 题目：求s=a+aa+aaa+aaaa+aa…a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)
     */
    private static void test6(int num, int time) {
        double result = 0;
        double last = 0;
        for (int i = 0; i < time; i++) {
            last = last + num * Math.pow(10, (double) i);
            result = result + last;
        }
        System.out.println("result:" + result);
//        int two=num*10+num;
//        int three=two+num*100;
//        int four=three+num*1000;
//        int five=four+num*10000;
//        System.out.println("result:"+(num+two+three+four+five));
    }

    /**
     * 题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，
     * 求它在 第10次落地时，共经过多少米？第10次反弹多高？
     */
    private static void test7() {
        double lastHeight = 100;
        double totalHeight = lastHeight;
        for (int i = 1; i <= 10; i++) {
            lastHeight = lastHeight / 2;
            if (i == 10) {
                totalHeight = totalHeight + lastHeight;
            } else {
                totalHeight = totalHeight + lastHeight * 2;
            }
            System.out.println("height:" + lastHeight + " ,total height:" + totalHeight);
        }
        System.out.println("total height:" + totalHeight);
    }

    /**
     * 50个人围成一圈数到三和三的倍数时出圈，问剩下的人是谁？在原来的位置是多少？
     */
    private static void test8() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            list.add(i);
        }
        int count = 1;
        System.out.println(list.toString());
        Iterator iterator = list.iterator();
        while (list.size() != 1) {
            if (!iterator.hasNext()) {
                iterator = list.iterator();
                System.out.println(list.toString() + " ,count:" + count);
            }
            iterator.next();
            if (count % 3 == 0) {
                iterator.remove();
            }
            count++;
            System.out.println(list.toString() + " ,count:" + count);
        }
    }

    /**
     * n阶台阶,有2种走法,一种是1步1个台阶,一种是1步2个台阶,那么到顶端共有多少种走法
     */
    private static int test9(int step) {
        if (step == 0 || step == 1 || step == 2) {
            System.out.println("setp012:" + step);
            return step;
        }
        System.out.println("setp:" + step);
        return test9(step - 1) + test9(step - 2);
    }

    /**
     * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。
     * 求所有子数组的和的最大值。
     * 例如：输入的数组为{1，-2， 3， 10， -4， 7， 2， -5}，
     * 和最大的子数组为{3， 10， -4， 7， 2}，因此输出为该子数组的和18。
     */
    private static void test10() {
        int[] target = {1, -2, 3, 10, -4, 7, 2, -5};
        int sum = 0;
        int max = 0;
        for (int i = 0; i < target.length; i++) {
            sum = sum + target[i];
            if (target[i] >= 0) {
                if (max < sum) {
                    max = sum;
                }
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println("max:" + max);
    }

    //冒泡排序
    private static void test11() {
        int[] target = {3, 2, 7, 98, 6, 22, 1};
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length - 1; j++) {
                if (target[j + 1] > target[j]) {
                    int temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                    printArray(target);
                }
            }
        }
    }

    /**
     * 一个数组 两个数字的和恰好为N 求这两个数
     */
    private static void test12() {
        ArrayList<Integer> target = new ArrayList();
        target.add(3);
        target.add(5);
        target.add(2);
        target.add(9);
        target.add(7);

        int sum = 8;

        for (int i = 0; i < target.size(); i++) {
            ArrayList<Integer> temp = target;
            int z = target.get(i);
            temp.remove(i);
            for (int j = 0; j < temp.size(); j++) {
                if (temp.get(j) + z == sum) {
                    System.out.println(temp.get(j) + "+" + z);
                }
            }
        }
    }

    /**
     * 回文判断
     */
    private static void test13() {
        Scanner input = new Scanner(System.in);
        String target = input.next();
        StringBuilder reverse=new StringBuilder();
        char[] targetList=target.toCharArray();
        for (int i=target.length()-1;i>=0;i--){
            reverse.append(targetList[i]);
        }
        System.out.println("reverse:"+reverse+"\nis 回文:"+reverse.toString().equals(target));
        input.close();
    }

    private static void printArray(List list) {
        for (Object item : list) {
            System.out.print(item + ",");
        }
        System.out.println();
    }

    private static void printArray(int[] list) {
        for (int item : list) {
            System.out.print(item + ",");
        }
        System.out.println();
    }
}
