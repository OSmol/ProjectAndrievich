package javatr.task5.logic;

import javatr.task5.util.Data5;

import java.util.Scanner;

public class Logic5 {
    public static int findDividersOfNumberAndSum() {
        int number = Data5.enterNumber();
        int divider;
        for (divider = 1; divider < number; divider++) {
            if (number % divider == 0) {
                // System.out.println(divider);
            }
        }
        int sum = 0;
        sum = sum + divider;
        System.out.println(sum);
        return sum;
  }

  public static boolean findDifferenceBetweenNumberAndSumDividers(int sum, int number) {
boolean b=true;
        if(sum==number){
            System.out.println(b);
        }
        return b;
    }

}
