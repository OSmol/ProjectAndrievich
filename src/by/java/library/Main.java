package library;

import library.serializator.Serializator;
import library.bean.Book;

import java.io.InvalidObjectException;

/*
Создать консольное приложение "Учёт книг в домашней библиотеке".
Требования:
система учитывает книги в электронном и бумажном варианте.
существующие роли: пользователь, администратор.
пользователь может просматривать книги в каталоге книг, осуществлять поиск книг в каталоге.
администратор может модифицировать каталог.
При добавлении описания книги в каталог оповещение о ней рассылается на е-мейл всем пользователям.
При просмотре каталога желательно реализовать постраничный просмотр.
Пользователь может предложить добавить книгу в библиотеку, переслав ее название администратору по е-мейл.
Каталог книг хранится в текстовом файле. данные аутентификации пользователей хранятся в текстовом файле.
Пароль не хранится в открытом виде.
 */
public class Main {
    public static void main(String[] args) {
        Book book = new Book();
//запуск сериализатора
        String file = "/src/by/resources/library/Input.txt";
        Serializator serializator = new Serializator();
        serializator.serialization(book, file);
        // Book.genre = "History";
        Book result = null;
        try {
            result = serializator.deserialization(file);
        } catch (InvalidObjectException e) {
            //
        }
        System.out.println(result);
    }
}
