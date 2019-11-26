package javatrDay2.Task2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Main7forConsole {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        Calendar dayOfBirth = readDate(args, calendar);

        SimpleDateFormat format = new SimpleDateFormat("EEEE");

        System.out.println("You was born: " + format.format(dayOfBirth.getTime()));
        long difference = calendar.getTimeInMillis() - dayOfBirth.getTimeInMillis();
        format = new SimpleDateFormat("YYYY");

        System.out.println("You are " + (-1970 + Integer.parseInt(format.format(new Date(difference)))));
        if (calendar.get(Calendar.DAY_OF_MONTH) == dayOfBirth.get(Calendar.DAY_OF_MONTH)) {
            if (calendar.get(Calendar.MONTH) == dayOfBirth.get(Calendar.MONTH)) {
                System.out.println("Happy birthday!");
            }
        } else {
            System.out.println("No date");
        }
    }

    public static Calendar readDate(String[] args, Calendar calendar) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        Calendar calendar1 = new GregorianCalendar();
        String str = args[2] + "-" + args[1] + "-" + args[0];
        do {
            try {
                date = format.parse(str);
                calendar1.setTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } while (!calendar1.before(calendar));
        return calendar1;
    }
}

