package javatr.helper;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerHelper {


    public static int inputIntFromConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: ");
        return sc.nextInt();
    }


    public static String inputStringFromConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        return sc.nextLine();
    }

    public static double inputDoubleFromConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: ");
        return sc.nextDouble();
    }
}


