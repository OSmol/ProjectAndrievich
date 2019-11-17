package javatr.task6.logic;

import javatr.task6.util.Data6;

public class Logic6 {
    public static int countOfSecondsToThisMoment() {
        int hour, min, sec;
        int n = Data6.enterCoundOfSecond();
        if (n > 86400) {
            System.out.println("no ");
        }
        hour = n / 3600;
        n = n - hour * 3600;
        min = n / 60;
        n = n - min * 60;
        sec = n;
        System.out.println("jj" + n + " jj " + hour + "jj " + min + " jj" + sec);
        return sec;
    }
}
