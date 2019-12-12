package javatrDay5.task1;

import javatrDay5.helper.ScannerHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {
    private int[] mas = InputDateArray.inputRandom();

    public Array() {
    }

    public Array(int[] mas) {
        this.mas = mas;
    }

    public int[] getMas() {
        return mas;
    }

    public void setMas(int[] mas) {
        this.mas = mas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array = (Array) o;
        return Arrays.equals(mas, array.mas);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(mas);
    }

    @Override
    public String toString() {
        return "Array{" +
                "mas=" + Arrays.toString(mas) +
                '}';
    }

    public int[] sortBubble(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = i + 1; j < mas.length; j++) {
                if (mas[i] > mas[j]) {
                    int temp = mas[i];
                    mas[i] = mas[j];
                    mas[j] = temp;
                }
            }
        }
        return mas;
    }

    public int[] sortInsertion(int[] mas) {
        int j;
        for (int i = 0; i < mas.length; i++) {
            int temp = mas[i];
            for (j = i - 1; (j >= 0) && (mas[j] > temp); j--) {
                mas[j + 1] = mas[j];
            }
            mas[j + 1] = temp;
        }
        return mas;
    }

    public int[] sortSelection(int[] mas) {
        for (int i = 0; i < mas.length; i++) {//просматриваем массив
            int max = mas[i];//пусть первый эл-т явл максимальным
            int maxI = i;//индекс максимального элемента
            for (int j = i + 1; j < mas.length; j++) {//ищем эл больше максимума
                if (mas[j] < max) {
                    max = mas[j];
                    maxI = j;
                }
            }
            if (i != maxI) {//если нашелся эл больше чем текущий, меняем их местами
                int temp = mas[i];
                mas[i] = mas[maxI];
                mas[maxI] = temp;
            }
        }
        return mas;
    }


    public List<Integer> findElement(int[] mas) {
        int number = 5;
        int index = 0;

        for (int i = 1; i < mas.length; i++) {//циклом просматриваем ост эл-ты
            if (number == mas[i]) {
                index = i;
            }
        }
        // System.out.println("Искомый элемент" + number + "расположен на позиции" + index + ";");
        List<Integer> myList = new ArrayList<>();
        myList.add(index);
        //  System.out.println("My list" + myList);
        return myList;
    }

    public int maxMassive(int[] mas) {
        int max = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (max < mas[i]) {
                max = mas[i];
            }
        }
        // System.out.println(max + "max"); вывели после вызова метода, т.к. вызов здесь не придает гибкость для ПО
        return max;
    }


    public int minMassive(int[] mas) {
        int min = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (min > mas[i]) {
                min = mas[i];
            }
        }
        return min;
    }
//Получить все простые числа находящиеся в массиве.
    public int[] findSimpleNumberInArray(int[] mas) {
        return mas;
    }
//Получить все числа Фибонначчи находящиеся в массиве.
    public int[] findFibonacci(int[] mas) {
        return mas;
    }

    //Получить все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
    public int[] findThreeDigitNumbers(int[] mas) {
        return mas;
    }


}