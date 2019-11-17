package javatr.task9.logic;

import javatr.task9.util.Data9;

public class Logic9 {
    public static final double PI = 3.14;

    private double radius;

    public Logic9(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double calculateLength() {
        return 2 * PI * radius;
    }

    public double calculateSquare() {
        return PI * Math.pow(radius, 2);
    }

    public static double getLengthCircle() {
        double testRadius = Data9.getNumber();
        Logic9 testCircle = new Logic9(testRadius);
        return testCircle.calculateLength();
    }

    public static double getSquareCircle() {
        double testRadius = Data9.getNumber();
        Logic9 testCircle = new Logic9(testRadius);
        return testCircle.calculateSquare();
    }
}
