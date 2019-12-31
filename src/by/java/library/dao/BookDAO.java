package library.dao;

import library.bean.Book;
import library.dao.exception.DAOException;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;

public interface BookDAO {
    void addBook(Book book) throws DAOException;
    void deleteBook(int idBook) throws DAOException;
   // void deleteBook(Book book)throws DAOException;
    Book getBook(int idBook) throws DAOException;
    void getAllBooks(Book book) throws DAOException;
    void updateBook(Book book) throws DAOException;
}
