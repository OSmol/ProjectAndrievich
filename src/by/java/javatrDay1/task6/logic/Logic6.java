package javatrDay1.task6.logic;
//6. Идет n-я секунда суток, определить, сколько полных часов, полных минут и секунд прошло к этому моменту

public class Logic6 {
    public static int countOfSecondsToThisMoment(int n) {
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

        }
        return n;
    }
}
