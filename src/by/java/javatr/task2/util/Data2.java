package javatr.task2.util;

import javatr.helper.ScannerHelper;

public class Data2 {
    public static int getYear() {
        System.out.println("Задайте номер года.");
        int year = ScannerHelper.inputIntFromConsole();
        return year;
    }

    public static int getMonth() {
        System.out.println("Задайте номер месяца.");
        int month = ScannerHelper.inputIntFromConsole();
        return month;
    }

}

