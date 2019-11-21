package javatrDay1.task3.logic;
//3. Окружность вписана в квадрат заданной площади.
// Найти площадь квадрата, вписанного в эту окружность.
// Во сколько раз площадь вписанного квадрата меньше площади заданного?

import javatrDay1.task3.util.Data3;

public class Logic3 {

    private static double squareArea = Data3.sizeOfSquareArea();//ввели площадь внешнего квадрата
    private static double circleRadius = Math.sqrt(squareArea)/2;//нашли радиус круга


    public static double findSquareAreaInCircle() {//нашли площадь квадрата в круге
        double squareAreaInCircle = 0.5 * circleRadius * circleRadius * 4;
        return squareAreaInCircle;
    }

    public static double findDifferenceBetweenSquares(double squareAreaInCircle) {//нашли разницу
        return squareArea / squareAreaInCircle;
    }
}
