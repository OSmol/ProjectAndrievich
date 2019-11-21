package javatrDay1.task9.logic;

import javatrDay1.task9.util.Data9;

public class Logic9 {
    public static final double PI = 3.14;

    private static double radius;

    public Logic9(double radius) {
        Logic9.radius = Data9.getNumber();
    }

    public static double getPI() {
        return PI;
    }

    public static double getRadius() {
        return radius;
    }

    public static void setRadius(double radius) {
        Logic9.radius = radius;
    }

    public double calculateLength() {
        return 2 * PI * radius;
    }

    public double calculateSquare() {
        return PI * Math.pow(radius, 2);
    }

    public static double getLengthCircle() {
        Logic9 testCircle = new Logic9(getRadius());
        return testCircle.calculateLength();
    }

    public static double getSquareCircle() {
        Logic9 testCircle = new Logic9(getRadius());
        return testCircle.calculateSquare();
    }
}
