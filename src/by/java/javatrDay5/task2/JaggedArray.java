package javatrDay5.task2;

import java.util.Arrays;

public class JaggedArray {
    private int[][] a = JaggedArrayHelper.createJaggedArray();

    public JaggedArray() {
    }

    public JaggedArray(int[][] a) {
        this.a = a;
    }

    public int[][] getA() {
        return a;
    }

    public void setA(int[][] a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JaggedArray that = (JaggedArray) o;
        return Arrays.equals(a, that.a);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(a);
    }

    @Override
    public String toString() {
        return "JaggedArray{" +
                "a=" + Arrays.toString(a) +
                '}';
    }
    /*
Реализовать алгоритм "пузырьковой" сортировки таким образом, чтобы была возможность упорядочить строки матрицы:
в порядке возрастания (убывания) сумм элементов строк матрицы;
в порядке возрастания (убывания) максимальных элементов строк матрицы;
в порядке возрастания (убывания) минимальных элементов строк матрицы.
Для сортировки методы класса Array не использовать! Основное требование избежать повтора кода!!!!!
 */


    public int[][] sortBubbleJaggedArrayDecreasingRowTotals(int[][] a) {
int sum=0;
int sum1=0;
int sum2=0;

        return a;
    }

    public int[][] sortBubbleJaggedArrayMaxRowElements(int[][] a) {//убывания макс элементов строк - от макс к мин

     return a;}

   public int[][] sortBubbleJaggedArrayMinRowElements(int[][] a) {//от мин к макс
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i][j] < a[i][j + 1]) {
                    int temp = a[i][j];
                    a[i][j] = a[i][j + 1];
                    a[i][j + 1] = temp;
                }
            }
        }
        return a;
    }
}
