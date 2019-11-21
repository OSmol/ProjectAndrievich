package javatrDay1.helper;

import java.util.Scanner;

public class Console {


    public static int inputInt() {
        Scanner sc = new Scanner(System.in);
        int d;
        if (!sc.hasNextInt()) {
            do {
                sc.next();// read symbols
            } while (!sc.hasNextInt());
        }
        d = sc.nextInt();
        return d;
    }

    public static String inputStringFromConsole() {
        Scanner sc = new Scanner(System.in);
        String d;
        System.out.println("Введите строку: ");
        while (!sc.hasNextLine()) {
            sc.next();// read symbols
            System.out.println("Введите строку: ");
        }
        d = sc.nextLine();
        return d;
    }

    public static double inputDouble() {
        Scanner sc = new Scanner(System.in);
        double d;
        //  System.out.println("Введите число: ");
        while (!sc.hasNextDouble()) {
            sc.next();// read symbols
            //     System.out.println("Введите число: ");
        }
        d = sc.nextDouble();
        return d;
    }
}


