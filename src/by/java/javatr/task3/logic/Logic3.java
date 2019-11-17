package javatr.task3.logic;

import javatr.task3.util.Data3;

public class Logic3 {
    public static double findSquareArea() {
        double squareArea = Data3.sizeOfSquareArea(); //площадь квадрата
        return squareArea;
    }

    public static double findSquareSide(double squareArea) {
        double squareSide = Math.sqrt(squareArea);
        return squareSide;
    }

    public static double findCircleRadius(double squareSide) {
        double circleRadius = squareSide / 2;
        return circleRadius;
    }

    public static double findSquareAreaInCircle(double circleRadius) {
        double squareAreaInCircle = 0.5 * circleRadius * circleRadius * 4;
        return squareAreaInCircle;
    }

    public static double findDifferenceBetweenSquares(double squareArea, double squareAreaInCircle) {
        double difference = squareArea / squareAreaInCircle; //разница между площадями двух квадратов
        return difference;
    }
}
