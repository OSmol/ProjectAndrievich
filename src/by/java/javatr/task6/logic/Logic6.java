package javatr.task6.logic;
//6. Идет n-я секунда суток, определить, сколько полных часов, полных минут и секунд прошло к этому моменту

import javatr.task6.util.Data6;

public class Logic6 {
    public static String countOfSecondsToThisMoment() {
        String s = "***";
        int n = Data6.enterCoundOfSecond();
        int hour, min, sec;
        if (n > 86400) {
            System.out.println("Слишком большое число! Больше секунд в сутках нет! ");

        } else {
            hour = n / 3600;
            int n1 = n - hour * 3600;
            min = n1 / 60;
            n1 = n1 - min * 60;
            sec = n1;
            System.out.println("Идет " + n + " секунда суток. Значит к этому моменту прошло  " + hour + " часов,  " + min + " минут , " + sec + " секунд.");
            return s;
        }
        return s;
    }
}
