package javatrDay1.task5.logic;
//5. Составить программу, печатающую значение true, если указанное высказывание является истинным, и
//false — в противном случае: является ли целое число совершенным (сумма делителей равна самому
//числу).

import javatrDay1.task5.util.Data5;

public class Logic5 {
    public static boolean findDividersOfNumberAndSum(int number) {
        boolean b = true;
        int sumOfDividers = 0;
        int divider;

        for (divider = 1; divider < number; divider++) {
            if (number % divider == 0) {
                sumOfDividers = sumOfDividers + divider;
            }
        }

        if (sumOfDividers == number) {
            System.out.println(true);
            System.out.println("Число совершенное");
        } else {
            b = false;
            System.out.println("Число не совершенное." );
        }
        return b;
    }
}
