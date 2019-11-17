package javatr.task10.logic;

import javatr.task10.util.Data10;
import javatr.task9.util.Data9;

//10. Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h. Результат
//представить в виде таблицы, первый столбец которой – значения аргумента, второй - соответствующие значения функции.
//F(x) = tg(x)
public class Logic10 {
    public static double findFunction(){
int x;
double function=0;
int a = Data10.enterNumber();
int b = Data10.enterNumber();
int h = Data10.enterNumber();
while ((x <= b) && (x >= a)){
 function=Math.atan(x);
    x=x+h;
    }
return function;
}}
