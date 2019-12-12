package javatrDay5.task1;

import javatrDay5.helper.ScannerHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class InputDateArray {
    public static int[] inputRandom() {
        Random rand = new Random();
        //  int size = ScannerHelper.inputInt();//размер массива, финальная константа, с маленькой, тк final внутри метода
        int size = 10;
        int[] mas = new int[size];
        int maxValueOfMassive = 30;//не изм тоже
        for (int i = 0; i < size; i++) {
            mas[i] = rand.nextInt(maxValueOfMassive) - 15;//в массиве сод цифры до 30, диапаз от -15 до 15
            //  System.out.println(mas[i]); вывод после вызова метода
        }
        return mas;
    }

    public static int[] inputFromConsole() {
        int size = 10;
        int[] mas = new int[size];
        for (int i = 0; i < size; i++) {
            int data = ScannerHelper.inputInt();//по одной строчке из консоли
            mas[i] = data;
        }
        return mas;
    }

    public static int[] inputFromFile() throws FileNotFoundException {
        int size = 10;
        int[] mas = new int[size];
        String path = "/home/siarhei/IdeaProjects/ProjectAndrievich/dir/for Array.txt";
        Scanner scanner = new Scanner(new File(path));
        for (int i=0;scanner.hasNextInt();i++){
            mas[i]=scanner.nextInt();
        }
        return mas;
    }
}
