package javatr.task9.runner;
//9. Вычислить длину окружности и площадь круга одного и того же заданного радиуса R.

import javatr.task9.logic.Logic9;
import javatr.task9.util.Data9;

public class Main9 {
    public static void main(String[] args) {
        System.out.println("Введите значение радиуса: ");
        System.out.println("Длина окружности при данном значении радиуса= " + Logic9.getLengthCircle());
        System.out.println("Введите значение радиуса: ");
        System.out.println("Площадь круга при данном значении радиуса= " + Logic9.getSquareCircle());
    }
}