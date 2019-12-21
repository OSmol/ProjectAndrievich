package javatrDay5.task3;

public class Text {

    //В каждом слове k-ю букву заменить заданным символом. Если k больше длины слова, корректировку не выполнять.
    public static String[] replaceKGivenCharacter(String str, int k) {
        String[] words = str.split("[\\s\\.\\!\\,]");
        for (int i = 0; i < words.length; i++) {
            if (k < words[i].length()) {
                String temp = "";
                temp = temp + words[i].substring(0, k - 1);
                temp = temp + '@';
                temp = temp + words[i].substring(k);
                words[i] = temp;
            }
        }
        return words;
    }

    public static String replaceO(String str) {
        str = str.replace("pa", "po");
        return str;
    }

    //   В тексте слова заданной длины заменить указанной подстрокой, длина которой может не совпадать с длиной слова.
    public static String[] replaceWord(String str) {
        String[] words = str.split("[\\s \\.\\!\\,]");
        String s = "new";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 2) {
                System.out.println(words[i].replace(words[i], s)); ;

            }
        }
        return words;
    }
}