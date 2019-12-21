package javatrDay5.task2;

import java.util.Arrays;

/*
Дан непрямоугольный целочисленный массив (jagged array). Реализовать алгоритм "пузырьковой" сортировки,
таким образом, чтобы была возможность упорядочить строки матрицы:
в порядке возрастания (убывания) сумм элементов строк матрицы;
в порядке возрастания (убывания) максимальных элементов строк матрицы;
в порядке возрастания (убывания) минимальных элементов строк матрицы.
Для сортировки методы класса Array не использовать! Основное требование избежать повтора кода!!!!!
 */
public class Main {
    public static void main(String[] args) {
        JaggedArray jaggedArray = new JaggedArray();
        System.out.println(Arrays.deepToString(JaggedArrayHelper.createJaggedArray()));
        System.out.println(Arrays.deepToString(jaggedArray.sortBubbleJaggedArrayDecreasingRowTotals(JaggedArrayHelper.createJaggedArray())));
        System.out.println(jaggedArray);
        }
}
