package javatrDay1.task4.logic;

public class Logic4 {
    public static int takeNumbers(int a, int b, int c, int d) {
        int count = 0;
        if ((a % 2 == 0)&&(a!=0)) { //четное число
            count++;
        }
        if ((b % 2 == 0)&&(b!=0)) { //четное число
            count++;
        }
        if((c % 2 == 0)&&(c!=0)) { //четное число
            count++;
        }
        if ((d % 2 == 0)&&(d!=0)) { //четное число
            count++;
        }

        if (count >= 2) {
            System.out.println("В последовательности есть два и более четных числа");
            System.out.println("Количество четных чисел в последовательности = " + count);
        } else {
            System.out.println("В последовательности нет двух четных чисел");
            System.out.println("Количество четных чисел в последовательности = " + count);
        }
        return count;
    }
}

