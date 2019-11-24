package javatrDay2.Task2;

import java.util.Arrays;
import java.util.Random;

public class Main3 {
    public static void main(String[] args) {
        //3.создать приложение, выводящее заданное количество случайных чисел с переходом и без перехода на новую строку
        Random random = new Random();
        int size = 5;
        int maxValueOfArray = 10;
        int[] a = new int[size];
        System.out.println("Вывод случайных чисел с переходом на новую строку: ");
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(maxValueOfArray);
            System.out.println(a[i]);
        }
        System.out.println("Вывод случайных чисел без перехода на новую строку: ");
        System.out.print(Arrays.toString(a));
    }
}
