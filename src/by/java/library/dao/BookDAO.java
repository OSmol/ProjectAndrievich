package library.dao;

import library.bean.Book;
import library.dao.exception.DAOException;

public interface BookDAO {
    boolean addBook(Book book) throws DAOException;
    void deleteBook(long idBook) throws DAOException;
    void deleteBook(Book book)throws DAOException;
    void getBook(int idBook) throws DAOException;
    void getAllBooks(Book book) throws DAOException;
    void updateBook(Book book) throws DAOException;
}
