package javatrDay1.task2.logic;

import javatrDay1.task2.util.Data2;

public class Logic2 {
    public static int countOfDaysThisYear(int numberOfMonth, int numberOfYear) {
        int countOfDaysInMonth = 0;
        switch (numberOfMonth) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                countOfDaysInMonth = 31;
                break;
            case 2:
                if (numberOfYear % 4 == 0) {
                    countOfDaysInMonth = 29;
                    System.out.println("Этот год високосный.");
                } else countOfDaysInMonth = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                countOfDaysInMonth = 30;
                break;
        }
        return countOfDaysInMonth;
    }
}
