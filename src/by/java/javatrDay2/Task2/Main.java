package javatrDay2.Task2;
/*
1.создать класс Хелло, который будет приветствовать любого пользователя при вводе его имени через командную строку
2.создать приложение, которое отображает в окне консоли аргументы командной строки метода мэйн в обратном порядке
3.создать приложение, выводящее заданное количество случайных чисел с переходом и без перехода на новую строку
4.создать приложение для вообда пароля из командной строки и сравнения его со строкой-образцом
5.создать программу ввода целых чисел как аргументов командной строки, подсчета их суммы(произведения) и вывода результата на консоль
6. приложение, выводящее фамилию разработчика и за сколько дней готов выполнить задание.
  необходимо рассчитать дату и время сдачи задания. Для получения даты и времени использовать класс Календарь из
  пакета джава утил.
7. создать приложение, получающее дату рождения (день, месяц и год) и определяющее, в какой день недели вы родились,
сколько вам полных лет и поздравляет с днем рождения, если оно сегодня (использовать класс Календарь из пакета джава утил
8. запустить приложение из командной строки (в текстовом документе подробно описать последовательность выполнения со скриншотами)
*/

import javatrDay2.helper.ScannerHelper;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//1. Приветствовать любого пользователя при вводе его имени через командную строку.
        System.out.println("Введите свое имя: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Hello,  " + name + " !");

//2. Отобразить в окне консоли аргументы командной строки в обратном порядке.

        System.out.print("Введите последовательность цифр: ");
        int number = ScannerHelper.inputInt();
        int reverse = 0;
        while (number != 0) {
            reverse =   (number % 10)+reverse * 10;
            number = number / 10;
        }
        System.out.print(reverse);

//3.создать приложение, выводящее заданное количество случайных чисел с переходом и без перехода на новую строку
        Random random = new Random();
        int size = 5;
        int maxValueOfArray = 10;
        int[] a = new int[size];
        for (int i : a) {
            a[i] = random.nextInt(maxValueOfArray);
            System.out.println(a[i] + "  ");
            System.out.print(a[i] + "  ");
        }
//4.создать приложение для ввода пароля из командной строки и сравнения его со строкой-образцом

        System.out.println("Введите пароль: ");
        String password1 = scanner.next();
        String password2 = "test";
        if (password1.equals(password2)) {
            System.out.println("Пароль верный");
        } else {
            System.out.println("Пароль не верный");
        }

 //5. Ввести целые числа как аргументы командной строки, подсчитать их суммы (произведения) и вывести результат на консоль.

        System.out.println("Ввести  целые числа: ");
        int value1 = ScannerHelper.inputInt();
        int sum = 0;
        int com = 1;
        while (value1 != 0) {  //подсчитать сумму чисел
            sum = sum + value1 % 10;
            value1 = value1 / 10;
        }
        System.out.println("Сумма введенных чисел: " + sum);
        System.out.println("Произведение введенных чисел: " + com);

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
