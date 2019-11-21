package javatrDay1.task10.logic;

import javatrDay1.task10.util.Data10;

//10. Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h. Результат
//представить в виде таблицы, первый столбец которой – значения аргумента, второй - соответствующие значения функции.
//F(x) = tg(x)
public class Logic10 {
    public static String findFunction() {
        String s = "Все значения функции вычислены. Программа завершила работу.";
        double x;
        double function = 0;

        System.out.println("Начало отрезка. ");
        int a = Data10.enterNumber();
        System.out.println("Конец отрезка. ");
        int b = Data10.enterNumber();
        System.out.println("Шаг.");
        int h = Data10.enterNumber();
        System.out.println("x  " + " |  " + "function");
        for (x = a; x <= b; x += h) {
            function = Math.atan(x);

            System.out.println(x + " |  " + function);

        }
        return  s;
    }
}
