package javatrDay2.Task2;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        //4.создать приложение для ввода пароля из командной строки и сравнения его со строкой-образцом
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пароль: ");
        String password1 = scanner.next();
        String password2 = "test";
        if (password1.equals(password2)) {
            System.out.println("Пароль верный");
        } else {
            System.out.println("Пароль не верный");
        }
    }
}
