package javatr.task3.runner;

import javatr.task3.logic.Logic3;
import javatr.task3.util.Data3;

//3. Окружность вписана в квадрат заданной площади. Найти площадь квадрата, вписанного в эту
//окружность. Во сколько раз площадь вписанного квадрата меньше площади заданного?
public class Main3 {
    public static void main(String[] args) {
        System.out.println("difference=" + Logic3.findDifferenceBetweenSquares(Logic3.findSquareArea(), Logic3.findSquareAreaInCircle(Logic3.findCircleRadius(Logic3.findSquareSide(Logic3.findSquareArea())))));
    }
}
