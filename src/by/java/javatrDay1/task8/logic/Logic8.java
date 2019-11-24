package javatrDay1.task8.logic;

import javatrDay1.task8.util.Data8;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Logic8 {
    public static double getNumber() {
        double x = Data8.enterX();
        return x;
    }

    public static double findFunction(double x) {
        double fx;
        if (x >= 3) {
            fx = -x * x + 3 * x + 9;

        } else {
            fx = 1 / (Math.pow(x, 3) - 6);
        }
        fx=new BigDecimal(fx).setScale(3, RoundingMode.UP).doubleValue();
        return fx;
    }
}
