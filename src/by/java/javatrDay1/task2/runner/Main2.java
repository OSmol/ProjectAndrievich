package javatrDay1.task2.runner;

import javatrDay1.task2.logic.Logic2;
import javatrDay1.task2.util.Data2;

//2. Составить программу, которая по заданным году и номеру месяца определяет количество дней в этом месяце
// и корректно определялись все високосные года.

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Количество дней в данном месяце этого года :  " + Logic2.countOfDaysThisYear(Data2.getMonth(), Data2.getYear()));
    }
}
