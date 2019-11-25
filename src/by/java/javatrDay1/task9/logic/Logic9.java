package javatrDay1.task9.logic;

import javatrDay1.task9.util.Data9;

public class Logic9 {
    public static final double PI = 3.14;
    public static final double radius = Data9.getRadius();

    public double calculateLength(double radius) {
        return 2 * PI * radius;
    }

    public double calculateSquare(double radius) {
        return PI * Math.pow(radius, 2);
    }

    public static double getLengthCircle(double radius) {
        Logic9 testCircle = new Logic9();
        return testCircle.calculateLength(radius);
    }

    public static double getSquareCircle(double radius) {
        Logic9 testCircle = new Logic9();
        return testCircle.calculateSquare(radius);
    }
}
