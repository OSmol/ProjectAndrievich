package javatrDay2.Task2;


public class Main5 {
    public static void main(String[] args) {
        //5. Ввести целые числа как аргументы командной строки, подсчитать их суммы (произведения)
        // и вывести результат на консоль.

        int amount = 0, composition = 1; // сумма и произведение аргументов консоли
        for (String arg : args) {
            amount += Integer.parseInt(arg);
            composition *= Integer.parseInt(arg);
        }
        System.out.println("The amount of arguments: " + amount + "\nThe composition of arguments: " + composition);
    }
}
