package javatrDay1.task2.util;

import javatrDay1.helper.Console;

public class Data2 {
    public static int getYear() {
        System.out.println("Задайте номер года.");
        int year = Console.inputInt();
        return year;
    }

    public static int getMonth() {
        System.out.println("Задайте номер месяца.");
        int month = Console.inputInt();
        return month;
    }

}

