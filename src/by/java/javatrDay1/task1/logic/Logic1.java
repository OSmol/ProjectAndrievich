package javatrDay1.task1.logic;

import javatrDay1.task1.util.Data1;

public class Logic1 {

    public static int getNumber() {
        int number = Data1.getNumber();
        return number;
    }

    public static int findLastDigitSquareOfNumber(int number) {
        int lastDigitOfNumber;
        int lastDigitSquareOfNumber = 0;
        lastDigitOfNumber = number % 10;
        switch (lastDigitOfNumber) {
            case 0:
                lastDigitSquareOfNumber = 0;
                break;
            case 1:
                lastDigitSquareOfNumber = 1;
                break;
            case 2:
                lastDigitSquareOfNumber = 4;
                break;
            case 3:
                lastDigitSquareOfNumber = 9;
                break;
            case 4:
                lastDigitSquareOfNumber = 6;
                break;
            case 5:
                lastDigitSquareOfNumber = 5;
                break;
            case 6:
                lastDigitSquareOfNumber = 6;
                break;
            case 7:
                lastDigitSquareOfNumber = 9;
                break;
            case 8:
                lastDigitSquareOfNumber = 4;
                break;
            case 9:
                lastDigitSquareOfNumber = 1;
                break;
            default:
                System.out.println("Error!");

        }
        return lastDigitSquareOfNumber;
    }
}
