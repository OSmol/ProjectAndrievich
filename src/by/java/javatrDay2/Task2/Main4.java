package javatrDay2.Task2;
//4.создать приложение для ввода пароля из командной строки и сравнения его со строкой-образцом

import java.io.Console;

public class Main4 {
    public static void main(String[] args) {
        Console console = System.console();
        System.out.println();
        char[]password = console.readPassword("%s","Введите пароль: ");
        String password1 = new String(password);
        String password2 = "test";
        if (password1.equals(password2)) {
            System.out.println("Пароль верный");
        } else {
            System.out.println("Пароль не верный");
        }
    }
}
