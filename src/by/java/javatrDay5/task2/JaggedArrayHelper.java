package javatrDay5.task2;

public class JaggedArrayHelper {
    public static int[][] createJaggedArray() {
        int sizeOfArray = 3;
        int[][] a = new int[sizeOfArray][];
        a[0] = new int[]{1, 7, 3, 2};
        a[1] = new int[]{5, 9};
        a[2] = new int[]{0};
        return a;
    }

    public static void printJaggedArray(int[][] a, int n, int m) {
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                //    System.out.print(a[row][col] + " ");
            }
        }
    }
}


