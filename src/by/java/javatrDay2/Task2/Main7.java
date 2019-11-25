package javatrDay2.Task2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//7. создать приложение, получающее дату рождения (день, месяц и год) и определяющее, в какой день недели вы родились,
//сколько вам полных лет и поздравляет с днем рождения, если оно сегодня (использовать класс Календарь из пакета джава утил
public class Main7 {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
        Calendar calendar = new GregorianCalendar(2019, Calendar.NOVEMBER, 25, 10, 0, 0);
        System.out.println("День рождения:  " + dateFormat.format(calendar.getTime()));

        Calendar calendar1 = new GregorianCalendar();
        Date date = calendar1.getTime();
        System.out.println("Сегодня: " + dateFormat.format(date));
        long difference = date.getTime() - calendar.getTimeInMillis();//разница в милисекундах
        long years = ((difference / 1000) / 60) / 525600;//в годах
        System.out.println("Полных лет: " + years);

        }
    }

