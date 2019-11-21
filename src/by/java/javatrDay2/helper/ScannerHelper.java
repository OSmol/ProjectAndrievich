package javatrDay2.helper;

import java.util.Scanner;

public class ScannerHelper {


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
        while (!sc.hasNextLine()) {
            sc.next();// read symbols
        }
        d = sc.nextLine();
        return d;
    }
}


