package javatrDay1.task3.runner;

import javatrDay1.task3.logic.Logic3;
import javatrDay1.task3.util.Data3;

//3. Окружность вписана в квадрат заданной площади. Найти площадь квадрата, вписанного в эту
//окружность. Во сколько раз площадь вписанного квадрата меньше площади заданного?
public class Main3 {
    public static void main(String[] args) {
        System.out.println("Введите площадь внешнего квадрата: ");
        System.out.println("Площадь квадрата, вписанного в окружность= " + Logic3.findSquareAreaInCircle(Data3.sizeSquare));
        System.out.println("Площадь вписанного квадрата меньше площади заданного квадрата в  " + Logic3.findDifferenceBetweenSquares(Logic3.findSquareAreaInCircle(Data3.sizeSquare), Data3.sizeSquare) + " раз");
    }
}

