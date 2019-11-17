package javatr.task8.runner;

import javatr.task8.logic.Logic8;

//8. Вычислить значение функции: F(x)= -x2+3x+9, if x>=3;
//                                   = 1/(x3-6), if x<3;
public class Main {
    public static void main(String[] args) {
        System.out.println("F(x) = " + Logic8.findFunction());
    }
}
