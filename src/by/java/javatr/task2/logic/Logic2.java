package javatr.task2.logic;

import javatr.task2.util.Data2;

public class Logic2 {
    public static int countOfDaysThisYear() {
        int countOfDaysInMonth = 0;
        switch (Data2.getMonth()) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                Data2.getYear();
                countOfDaysInMonth = 31;
                break;
            case 2:
                if (Data2.getYear() % 4 == 0) {
                    countOfDaysInMonth = 29;
                    System.out.println("Этот год високосный.");
                } else countOfDaysInMonth = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                Data2.getYear();
                countOfDaysInMonth = 30;
                break;
        }
        return countOfDaysInMonth;
    }
}
