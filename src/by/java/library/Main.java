package library;


import library.bean.Book;
import library.dao.exception.DAOException;
import library.dao.impl.txt.TxtBookDAO;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;

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
    public static void main(String[] args) throws IOException, DAOException {
        Book book = new Book();

        book.setId(1);
        TxtBookDAO txtBookDAO = new TxtBookDAO();
     //   txtBookDAO.addBook(book);
//запуск сериализатора
   //     System.out.println(txtBookDAO.getBook(1).toString());
    //    System.out.println(txtBookDAO.createListOfBooks());
        System.out.println(txtBookDAO.getBooks());
;
    }
}
