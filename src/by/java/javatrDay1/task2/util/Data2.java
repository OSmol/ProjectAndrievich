package javatrDay1.task2.util;

import javatrDay1.helper.Console;

public class Data2 {
    public static int getYear() {
        System.out.println("Задайте номер года.");
        return Console.inputInt();
    }

    public static int getMonth() {
        System.out.println("Задайте номер месяца.");
        return Console.inputInt();
    }

}

