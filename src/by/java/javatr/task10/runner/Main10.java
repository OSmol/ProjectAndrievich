package javatr.task10.runner;

import javatr.task10.logic.Logic10;

import java.util.Arrays;

//10. Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h. Результат
//представить в виде таблицы, первый столбец которой – значения аргумента, второй - соответствующие
//значения функции.
//F(x) = tg(x)
public class Main10 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(Logic10.findFunction()) );
    }
}
