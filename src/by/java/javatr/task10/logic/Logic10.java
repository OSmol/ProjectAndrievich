package javatr.task10.logic;

import javatr.task10.util.Data10;
import javatr.task9.util.Data9;

//10. Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h. Результат
//представить в виде таблицы, первый столбец которой – значения аргумента, второй - соответствующие значения функции.
//F(x) = tg(x)
public class Logic10 {
    public static double [][] findFunction() {
        double x;
        double function = 0;
        double[][]arr = new double[20][20];
        System.out.println("Enter a");
        int a = Data10.enterNumber();
        System.out.println("Enter b");
        int b = Data10.enterNumber();
        System.out.println("Enter h");
        int h = Data10.enterNumber();

        for (x = a; x <= b;x++ ) {
            x = x + h;
            for (function=0; function<x; ++function){
                function=Math.atan(x);
                function=Math.round(function*100)/100.00;
             arr = new double[(int) x][(int) function] ;
                return arr;
            }
        }
        return arr;
    }
}
