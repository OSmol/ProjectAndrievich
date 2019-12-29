package library.service;

import library.bean.Book;
import library.bean.Country;
import library.bean.Genre;
import library.dao.exception.DAOException;
import library.service.exception.ServiceException;

import java.util.List;
import java.util.Set;

public interface BookService {
    void addBook(Book book) throws ServiceException;
    void addBooks(List<Book>books) throws ServiceException;
    void editBook(int id, String title, String author, String publishingHouse,
                 int year, String[] genresID, String[] countriesID, long isbn,
                 int countOfPages, String language, String authorOfTranslation,
                 String description, String averageMark, String customer, double price) throws ServiceException;

    List<Book> findBookByName(String nameBook) throws DAOException;
    List<Book> findBookByAuthor(String authorBook) throws DAOException;
    List<Book> findBookByGenre(String genre) throws DAOException;
    List<Book> sortBookByName(String nameBook) throws DAOException;
    List<Book> sortBookByDate(String date) throws DAOException;
    List<Book> sortBookByRating(String averageMark) throws DAOException;
}
