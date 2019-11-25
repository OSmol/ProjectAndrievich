package javatrDay1.task10.runner;

import javatrDay1.task10.util.Data10;

import static javatrDay1.task10.logic.Logic10.findFunction;

//10. Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h. Результат
//представить в виде таблицы, первый столбец которой – значения аргумента, второй - соответствующие
//значения функции.
//F(x) = tg(x)
public class Main10 {
    public static void main(String[] args) {
        System.out.println(findFunction(Data10.enterA(), Data10.enterB(), Data10.enterH()));
    }
}
