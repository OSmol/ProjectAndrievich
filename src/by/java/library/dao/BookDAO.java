package library.dao;

import library.bean.Book;
import library.dao.exception.DAOException;

import java.util.List;


public interface BookDAO {
    List<Book> getBooks() throws DAOException;

    void addBook(Book book) throws DAOException;

    void deleteBook(int idBook) throws DAOException;

    void deleteBook(Book book) throws DAOException;

    Book getBook(int idBook) throws DAOException;

    void updateBook(Book book) throws DAOException;


}
