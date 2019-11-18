package javatr.task2.util;

import javatr.helper.Console;

public class Data2 {
    public static int getYear() {
        System.out.println("Задайте номер года.");
        int year = Console.inputIntFromConsole();
        return year;
    }

    public static int getMonth() {
        System.out.println("Задайте номер месяца.");
        int month = Console.inputIntFromConsole();
        return month;
    }

}

