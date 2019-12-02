package javatrDay1.task2.logic;

//2. Составить программу, которая по заданным году и номеру месяца определяет количество дней в этом месяце
// и корректно определялись все високосные года.
public class Logic2 {
    public static int countOfDaysThisYear(int numberOfMonth, int numberOfYear) {
        int countOfDaysInMonth = 0;
        if ((numberOfMonth == 1) || (numberOfMonth == 3) || (numberOfMonth == 5) || (numberOfMonth == 7) || (numberOfMonth == 8) || (numberOfMonth == 10) || (numberOfMonth == 12)) {
            countOfDaysInMonth = 31;
        } else if (numberOfMonth == 2) {
            if (numberOfYear % 4 == 0) {
                countOfDaysInMonth = 29;
                System.out.println("Этот год високосный.");
            } else countOfDaysInMonth = 28;
        } else if (numberOfMonth == 4 || numberOfMonth == 6 || numberOfMonth == 9 || numberOfMonth == 11) {
            countOfDaysInMonth = 30;
        }
        return countOfDaysInMonth;
    }
}
