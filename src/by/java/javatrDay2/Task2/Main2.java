package javatrDay2.Task2;

import javatrDay2.helper.ScannerHelper;

public class Main2 {
    public static void main(String[] args) {
        //2. Отобразить в окне консоли аргументы командной строки в обратном порядке.

        System.out.print("Введите последовательность цифр: ");
        int number = ScannerHelper.inputInt();
        int reverse = 0;
        while (number != 0) {
            reverse =   (number % 10)+reverse * 10;
            number = number / 10;
        }
        System.out.print(reverse);
    }
}
