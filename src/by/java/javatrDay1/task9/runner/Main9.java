package javatrDay1.task9.runner;
//9. Вычислить длину окружности и площадь круга одного и того же заданного радиуса R.

import javatrDay1.task9.logic.Logic9;

public class Main9 {
    public static void main(String[] args) {
        System.out.println("Введите значение радиуса: ");
        System.out.println("Длина окружности при данном значении радиуса= " + Logic9.getLengthCircle(Logic9.radius));
        System.out.println("Площадь круга при данном значении радиуса= " + Logic9.getSquareCircle(Logic9.radius));
    }
}