package javatrDay1.task8.logic;

import javatrDay1.task8.util.Data8;

public class Logic8 {
    public static double findFunction(){
        double x = Data8.enterX();
        double fx;
        if (x>=3){
            fx = -x*x + 3*x+9;
        }else {
            fx = 1/(Math.pow(x,3) -6);
        }
        return fx;
    }
}
