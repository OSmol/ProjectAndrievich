package library.service.util;

import library.service.util.exception.UtilException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    private Pattern symbolsPattern;
    private Matcher matcher;

    private static final String SYMBOLS_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,14})" +
            "|((?=.*\\d)(?=.*[а-я])(?=.*[А-Я]).{8,14})";

    /* (?=.*\d)        пароль должен содержать как минимум одну цифру
     * (?=.*[a-z])     должен содержать как минимум букву в нижнем регистре
     * (?=.*[A-Z])     должен содержать как минимум букву в верхнем регистре
     * .     любое совпадение с предыдущими условиями
     * {8,14}            длина от 8 до 14 символов
     * Аналогичная запись для русского алфавита
     */

    public static void matchPassword(String password) throws UtilException {

            if (!password.matches(SYMBOLS_PATTERN)) {
                throw new UtilException("ошибка ввода данных");
            }
        }


    public static void isEmptyString(String password) throws UtilException {

            if (password.isEmpty()) {
                throw new UtilException("ошибка ввода данных - пустая строка");
            }
        }
    }




