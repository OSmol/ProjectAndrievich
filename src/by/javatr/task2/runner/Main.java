package task2.runner;

import task2.logic.Logic2;

//2. Составить программу, которая по заданным году и номеру месяца определяет количество дней в этом
//месяце и корректно определялись все високосные года.
public class Main {
    public static void main(String[] args) {
        System.out.println(Logic2.countOfDaysThisYear());
    }
}
