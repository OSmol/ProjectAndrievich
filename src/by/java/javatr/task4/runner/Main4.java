package javatr.task4.runner;

import javatr.task4.logic.Logic4;

//4. Составить программу, печатающую значение true, если указанное высказывание является истинным, и
//false — в противном случае: среди заданных целых чисел А, В, С, D есть хотя бы два четных.
public class Main4 {
    public static void main(String[] args) {
        System.out.println("Введите числа: ");
        System.out.println(Logic4.takeNumbers());
    }
}
