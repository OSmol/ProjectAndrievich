package javatrDay1.task7.runner;

import javatrDay1.task7.logic.Logic7;
import javatrDay1.task7.util.Data7;

//7. Даны две точки А(х1, у1) и В(х2, у2). Составить алгоритм, определяющий, которая из точек находится
//ближе к началу координат. x y.
public class Main7 {
    public static void main(String[] args) {
        System.out.println("Введите координаты : ");
       System.out.println(Logic7.comparePoint(Data7.enterPoint(),Data7.enterPoint(), Data7.enterPoint(), Data7.enterPoint()));
    }
}
