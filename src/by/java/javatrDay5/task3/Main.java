package javatrDay5.task3;

import javatrDay5.helper.ScannerHelper;

import java.util.Arrays;

/*Программа обработки текста, который может быть получен как с консоли, так и с файла.
1.В каждом слове k-ю букву заменить заданным символом. Если k больше длины слова, корректировку не выполнять.
2.В тексте после буквы Р, если она не последняя в слове, ошибочно напечатана буква А вместо О.
 Внести исправления в текст.
3.В тексте слова заданной длины заменить указанной подстрокой, длина которой может не совпадать с длиной слова.
4. Из небольшого текста удалить все символы, кроме пробелов, не являющиеся буквами.
Между последовательностями подряд идущих букв оставить хотя бы один пробел.
5. Из текста удалить все слова заданной длины, начинающиеся на согласную букву.*/
public class Main {
    public static void main(String[] args) {
      //  System.out.println(Arrays.toString(Text.replaceKGivenCharacter(ScannerHelper.inputStringFromConsole(), ScannerHelper.inputInt())));
      //  System.out.println(Text.replaceO(ScannerHelper.inputStringFromConsole()));
        System.out.println(Arrays.toString(Text.replaceWord(ScannerHelper.inputStringFromConsole())));
    }
}
