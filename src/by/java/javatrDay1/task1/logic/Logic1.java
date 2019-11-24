package javatrDay1.task1.logic;

import javatrDay1.task1.util.Data1;

public class Logic1 {

    public static int getNumber() {
        return Data1.getNumber();
    }

    public static int findLastDigitSquareOfNumber(int number) {
        return ((int) Math.pow((number % 10), 2)) % 10;
    }
}
