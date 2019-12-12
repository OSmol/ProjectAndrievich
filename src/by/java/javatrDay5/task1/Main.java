package javatrDay5.task1;
/*
Создание типа Array, который является классом оболочкой над массивом целого типа. В
данном типе должны быть реализованы конструкторы (позволяющие несколькими способами
создавать объекты типа), get-ы, set-ы и переопределенные методы класса Object (toString(),
equals(), hasCode()).
Программа должна иметь следующие возможности:
1. Сортировать массив тримя способами.
2. Осуществлять поиск элемента массива (использовать алгоритм бинарного поиска).
3. Нахождение максимального и минимального элемента массива.
4. Получить все простые числа находящиеся в массиве.
5. Получить все числа Фибонначчи находящиеся в массиве.
6. Получить все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
7. Заполнения элементов массива и с консоли, и с файла и с помощью генерации
случайных чисел.
 */
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Array array = new Array();
       // System.out.println("Enter size of array: ");
        System.out.println(Arrays.toString(array.sortBubble(array.getMas())));
        System.out.println(Arrays.toString(array.sortInsertion(array.getMas())));
        System.out.println(Arrays.toString(array.sortSelection(array.getMas())));
        System.out.println(Arrays.toString(array.findSimpleNumberInArray(array.getMas())));

        System.out.println(array.maxMassive(array.getMas()));
        System.out.println(array.minMassive(array.getMas()));
       // System.out.println("Enter number of array and press Enter: ");
       // System.out.println(Arrays.toString(InputDateArray.inputFromConsole()));
      //  System.out.println(Arrays.toString(InputDateArray.inputFromFile()));
    }
}


