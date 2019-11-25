package javatrDay1.task10.util;

import javatrDay1.helper.Console;

public class Data10 {
    public static int enterA() {
        System.out.println("Начало отрезка. ");
        int a = Console.inputInt();
        return a;
    }

    public static int enterB() {
        System.out.println("Конец отрезка. ");
        int b = Console.inputInt();
        return b;
    }

    public static int enterH() {
        System.out.println("Шаг.");
        int h = Console.inputInt();
        return h;
    }
}
