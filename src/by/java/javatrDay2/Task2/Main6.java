package javatrDay2.Task2;

import java.util.Calendar;
import java.util.Date;

public class Main6 {
    public static void main(String[] args) {
        //6. приложение, выводящее фамилию разработчика и за сколько дней готов выполнить задание.
        //  необходимо рассчитать дату и время сдачи задания.
        //  Для получения даты и времени использовать класс Календарь из пакета джава утил.
        String s = "Andrievich";
        Date d = new Date();
        System.out.println("Получения задания для " + s + " " + d);

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2019);
        c.set(Calendar.MONTH, Calendar.NOVEMBER);
        c.set(Calendar.DAY_OF_MONTH, 26);

        System.out.println("Сдача задания для " + s + " " + c.getTime());
    }
}
