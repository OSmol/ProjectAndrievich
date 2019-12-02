package javatrDay1.task4.logic;

public class Logic4 {
    public static boolean takeNumbers(int a, int b, int c, int d) {
        int count = 0;
        if ((a % 2 == 0) && (a != 0)) { //четное число
            count++;
        }
        if ((b % 2 == 0) && (b != 0)) { //четное число
            count++;
        }
        if ((c % 2 == 0) && (c != 0)) { //четное число
            count++;
        }
        if ((d % 2 == 0) && (d != 0)) { //четное число
            count++;
        }
        return count >= 2;
    }
}

