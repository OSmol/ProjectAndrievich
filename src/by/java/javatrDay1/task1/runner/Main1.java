package javatrDay1.task1.runner;
//Написать программу, позволяющую по последней цифре числа определить последнюю цифру его квадрата.

import javatrDay1.task1.logic.Logic1;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Введите число:  ");
        System.out.println("Последняя цифра квадрата введенного числа: " + Logic1.findLastDigitSquareOfNumber(Logic1.getNumber()));
    }
}
