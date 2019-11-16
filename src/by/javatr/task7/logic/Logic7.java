package task7.logic;

import task7.util.Data7;

public class Logic7 {
    public static double comparePoint(int x1, int x2, int y1, int y2) {
        System.out.println();

        double a = Math.sqrt(x1 * x1 + y1 - y1);
        double b = Math.sqrt(x2 * x2 + y2 * y2);
        if (a < b) {
            System.out.println("b near ");
        } else if (a > b) {
            System.out.println("a near");
        } else {
            System.out.println("==");
        }
       return a;
    }
}
