package library;

import library.controller.Request;
import library.controller.command.impl.FindBookByNameCommand;
import library.service.exception.ServiceException;
import library.service.impl.BookServiceImpl;
import library.view.BookPage;
import library.view.UserPage;

/*
Создать консольное приложение "Учёт книг в домашней библиотеке".
Требования:
1) система учитывает книги в электронном и бумажном варианте.
2) существующие роли: пользователь, администратор.
3) пользователь может просматривать книги в каталоге книг, осуществлять поиск книг в каталоге.
4) администратор может модифицировать каталог.
7) При добавлении описания книги в каталог оповещение о ней рассылается на е-мейл всем пользователям.
9) При просмотре каталога желательно реализовать постраничный просмотр.
8) Пользователь может предложить добавить книгу в библиотеку, переслав ее название администратору по е-мейл.
5) Каталог книг хранится в текстовом файле. данные аутентификации пользователей хранятся в текстовом файле.
6) Пароль не хранится в открытом виде.
 */
public class Main {
    public static void main(String[] args) throws ServiceException {
        BookPage bookPage = new BookPage();
        UserPage userPage = new UserPage();
        bookPage.run();
        // userPage.run();

    }
}

