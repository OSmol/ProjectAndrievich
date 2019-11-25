package javatrDay1.task10.logic;

import javatrDay1.task10.util.Data10;

import java.math.BigDecimal;
import java.math.RoundingMode;

//10. Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h. Результат
//представить в виде таблицы, первый столбец которой – значения аргумента, второй - соответствующие значения функции.
//F(x) = tg(x)
public class Logic10 {
    public static double findFunction(int a, int b, int h) {

        double function = 0;
        System.out.println("x  " + " |  " + "function");//это часть таблицы
        for (double x = a; x <= b; x += h) {
            function = Math.atan(x);
            function = new BigDecimal(function).setScale(3, RoundingMode.UP).doubleValue();
            System.out.println(x + " |  " + function);//это часть таблицы
        }
        return function;
    }
}
