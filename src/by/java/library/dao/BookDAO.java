package library.dao;

import library.bean.Book;
import library.dao.exception.DAOException;

public interface BookDAO {
    void addBook(Book book) throws DAOException;
    void deleteBook(long idBook) throws DAOException;
    void delete(Book book)throws DAOException;
}
