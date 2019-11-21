package javatrDay1.task7.logic;

//7. Даны две точки А(х1, у1) и В(х2, у2). Составить алгоритм, определяющий, которая из точек находится
//ближе к началу координат. x y.
public class Logic7 {
    public static String comparePoint(int x1, int x2, int y1, int y2) {
        System.out.println();
        String s = "***";
        double a = Math.sqrt(x1 * x1 + y1 - y1);
        double b = Math.sqrt(x2 * x2 + y2 * y2);
        if (a < b) {
            System.out.println("Ближе точка Б ");
        } else if (a > b) {
            System.out.println("Ближе точка А");
        } else {
            System.out.println("Обе точки находятся на одинаковом расстоянии от начала координат");
        }
        return s;
    }
}
