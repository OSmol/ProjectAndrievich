package javatrDay1.task3.logic;
//3. Окружность вписана в квадрат заданной площади.
// Найти площадь квадрата, вписанного в эту окружность.
// Во сколько раз площадь вписанного квадрата меньше площади заданного?

import javatrDay1.task3.util.Data3;

public class Logic3 {

      public static double findSquareAreaInCircle(double squareAreaOutCircle) {//нашли площадь квадрата в круге
        double squareAreaInCircle = 0.5 * Math.pow((Math.sqrt(squareAreaOutCircle)/2),2) * 4;
        return squareAreaInCircle;
    }

    public static double findDifferenceBetweenSquares(double squareAreaInCircle, double squareAreaOutCircle) {//нашли разницу
        return squareAreaOutCircle / squareAreaInCircle;
    }
}
