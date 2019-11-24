package javatrDay2.Task2;

import java.util.Scanner;

//1. Приветствовать любого пользователя при вводе его имени через командную строку.
public class Main1 {
    public static void main(String[] args) {
        System.out.println("Введите свое имя: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Hello,  " + name + " !");
    }
}
