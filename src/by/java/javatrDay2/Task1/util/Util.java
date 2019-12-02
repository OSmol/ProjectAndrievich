package javatrDay2.Task1.util;

import javatrDay2.Task1.bean.Ball;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<Ball> generateBalls() {
        List<Ball> list = new ArrayList<>();
        list.add(new Ball(5, Color.BLUE, 5, 25));
        list.add(new Ball(321, Color.BLUE, 7, 3));
        list.add(new Ball(22, Color.WHITE, 8, 41));
        list.add(new Ball(123, Color.RED, 1, 23));
        list.add(new Ball(145, Color.RED, 36, 14));
        return list;
    }
}
