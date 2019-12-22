package library.dao;

import library.bean.Book;
import library.dao.exception.DAOException;

public interface BookDAO {
    void addBook(Book book) throws DAOException;
    void deleteBook(long idBook) throws DAOException;
    void delete(Book book)throws DAOException;
    void getBook(int idBook) throws DAOException;
    void findBookByName(String nameBook) throws DAOException;
    void findBookByAuthor(String authorBook) throws DAOException;
    void findBookByGenre(String genre) throws DAOException;
    void sortBookByName(String nameBook) throws DAOException;
    void sortBookByDate(String date) throws DAOException;
    void sortBookByRating(String averageMark) throws DAOException;
}
