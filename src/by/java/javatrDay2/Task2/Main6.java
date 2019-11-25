package javatrDay2.Task2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        //6. приложение, выводящее фамилию разработчика и за сколько дней готов выполнить задание.
        //  необходимо рассчитать дату и время сдачи задания.
        //  Для получения даты и времени использовать класс Календарь из пакета джава утил.
        System.out.println("Введите фамилию разработчика: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Hello,  " + name + " !");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
        Calendar calendar = new GregorianCalendar(2019, Calendar.NOVEMBER, 20, 10, 0, 0);
        System.out.println("Время получения задания для " + name + ": " + dateFormat.format(calendar.getTime()));

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2019);
        c.set(Calendar.MONTH, Calendar.NOVEMBER);
        c.set(Calendar.DAY_OF_MONTH, 26);
        c.set(Calendar.HOUR_OF_DAY, 10);
        System.out.println("Время сдачи задания для " + name + ": " + dateFormat.format(c.getTime()));

        long difference = c.getTimeInMillis() - calendar.getTimeInMillis();
        long seconds = difference / 1000; // в секундах
        long minutes = seconds / 60;// в минутах
        long hours = minutes / 60;// в часах
        long days = hours / 24;// в днях
        System.out.println("Разработчик " + name + "  сделает задание за " + days + " дней.");
    }
}
