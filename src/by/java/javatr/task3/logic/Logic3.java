package javatr.task3.logic;

import javatr.task3.util.Data3;

public class Logic3 {
    public static double findSquareArea() {
        double squareArea = Data3.sizeOfSquareArea();//ввели площадь внешнего квадрата
       return squareArea;
   }

    public static double findSquareSide(double squareArea) {
        double squareSide = Math.sqrt(squareArea);//нашли сторону квадрата
        return squareSide;
    }

    public static double findCircleRadius(double squareSide) {//нашли радиус круга
        return squareSide / 2;
    }

    public static double findSquareAreaInCircle(double circleRadius) {//нашли площадь квадрата в круге
        return 0.5 * circleRadius * circleRadius * 4;
    }

    public static double findDifferenceBetweenSquares(double squareArea, double squareAreaInCircle) {//нашли разницу
        return squareArea / squareAreaInCircle;
    }
}
