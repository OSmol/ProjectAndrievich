package scanner;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskScanner {


    public static int scannerInt() {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        try {
            System.out.println("Введите число типа int: ");
            if (sc.hasNextInt()){
            a = sc.nextInt();}
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели число неправильного типа или вообще не число. Попробуйте еще раз!");
        }
      //  sc.close();
        return a;
    }

    public static String scannerString() {
        Scanner sc = new Scanner(System.in);
        String a = null;
        try {
            System.out.println("Введите значение типа String: ");
            a = sc.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println("Вы ввели значение неправильного типа. Попробуйте еще раз!");
        }
      //  sc.close();
        return a;

    }
}

     /*   if (sc.hasNextDouble()) {
            double b = sc.nextDouble();
            System.out.println(b);
        }

        if (sc.hasNextByte()) {
            byte d = sc.nextByte();
            System.out.println(d);
        }
        if (sc.hasNextLine()) {
            String e = sc.nextLine();
            System.out.println(e);
        }*/


/*
    public static int scannerForInt(Scanner sc) {
        int a = 0;
        System.out.print("Введите число или символ");
        if (sc.hasNextInt()) {
            a = sc.nextInt();
            System.out.println("Спасибо! Вы ввели число " + a);
        } else {
            System.out.println("Извините, попробуйте снова!");

        }
        return a;
    }

    public static double scannerForDouble(Scanner sc) {
        double a = 0;
        System.out.print("Введите число типа Double: ");
        if (sc.hasNextDouble()) {
            a = sc.nextDouble();
            System.out.println("Спасибо! Вы ввели число " + a);
        } else {
            System.out.println("Извините, попробуйте снова!");

        }
        return a;
    }

}*/


