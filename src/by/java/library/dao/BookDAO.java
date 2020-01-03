package library.dao;

import library.bean.Book;
import library.dao.exception.DAOException;



public interface BookDAO {
    void addBook(Book book) throws DAOException;

    void editBook(Book book) throws DAOException;//связь с файлом

    void deleteBook(int idBook) throws DAOException;

    void deleteBook(Book book) throws DAOException;

    Book getBook(int idBook) throws DAOException;

 //   void getBooks(Book book) throws DAOException;

    void updateBook(Book book) throws DAOException;


}
