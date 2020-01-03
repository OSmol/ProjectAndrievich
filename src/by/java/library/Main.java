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
