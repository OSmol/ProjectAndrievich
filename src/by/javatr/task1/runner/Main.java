package task1.runner;
//Написать программу, позволяющую по последней цифре числа определить последнюю цифру его квадрата.

import scanner.TaskScanner;
import task1.logic.Logic1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Последняя цифра квадрата введенного числа: " + Logic1.poslCyfra(Logic1.makeNumber()));

    }
}
