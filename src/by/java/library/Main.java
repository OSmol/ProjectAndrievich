package library;


import library.bean.Book;
import library.bean.User;
import library.dao.BookUserDAO;
import library.dao.exception.DAOException;
import library.dao.impl.txt.TxtBookDAOImpl;

import java.io.IOException;

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
    public static void main(String[] args) throws IOException, DAOException {
        Book book = new Book();
        User user = new User();
        BookUserDAO bookUserDAO = new BookUserDAO();
        bookUserDAO.createUser(user, book);
        bookUserDAO.loadUsersByName(user.getName());
        book.setId(1);
        TxtBookDAOImpl txtBookDAO = new TxtBookDAOImpl();
        //   txtBookDAO.addBook(book);
//запуск сериализатора
        //     System.out.println(txtBookDAO.getBook(1).toString());
        //    System.out.println(txtBookDAO.createListOfBooks());
        System.out.println(txtBookDAO.getBooks());
        ;
    }
}
