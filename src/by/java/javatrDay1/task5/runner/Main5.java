package javatrDay1.task5.runner;

import javatrDay1.task5.logic.Logic5;
import javatrDay1.task5.util.Data5;

//5. Составить программу, печатающую значение true, если указанное высказывание является истинным, и
//false — в противном случае: является ли целое число совершенным (сумма делителей равна самому
//числу).
public class Main5 {
    public static void main(String[] args) {
        Logic5.findDividersOfNumberAndSum(Data5.enterNumber());

    }
}
