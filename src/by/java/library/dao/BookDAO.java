package library.dao;

import library.bean.Book;
import library.dao.exception.DAOException;

import java.io.IOException;
import java.io.InvalidObjectException;

public interface BookDAO {
    boolean addBook(Book book) throws DAOException, IOException;
    void deleteBook(long idBook) throws DAOException;
    void deleteBook(Book book)throws DAOException;
    Book getBook(int idBook) throws DAOException, InvalidObjectException;
    void getAllBooks(Book book) throws DAOException;
    void updateBook(Book book) throws DAOException;
}
