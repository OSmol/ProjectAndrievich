package javatr.task4.logic;

import javatr.task4.util.Data4;

public class Logic4 {
    public static String takeNumbers() {
        String s = "Программа завершила работу.";
        int count = 0;
        int a = Data4.enterNumbers();
        int b = Data4.enterNumbers();
        int c = Data4.enterNumbers();
        int d = Data4.enterNumbers();

        if (a % 2 == 0) { //четное число
            count++;
        }
        if (b % 2 == 0) { //четное число
            count++;
        }
        if (c % 2 == 0) { //четное число
            count++;
        }
        if (d % 2 == 0) { //четное число
            count++;
        }

        if (count >= 2) {
            System.out.println("В последовательности есть два и более четных числа");
        } else {
            System.out.println("В последовательности нет двух четных чисел");
        }

        return s;
    }
}

