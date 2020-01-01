package library.service;

import library.bean.Book;
import library.bean.Country;
import library.bean.Genre;
import library.bean.Person;
import library.dao.exception.DAOException;
import library.service.exception.ServiceException;


import java.util.List;
import java.util.Set;

public interface BookService {


    void addBook(String title, Person author, String publishingHouse, int year, Set<Genre> genres,
                 Set<Country> countries, long isbn, int countOfPages, String language, Person authorOfTranslation,
                 String description, double price) throws ServiceException;

    void editBook(String title, Person author, String publishingHouse, int year, Set<Genre> genres,
                  Set<Country> countries, long isbn, int countOfPages, String language, Person authorOfTranslation,
                  String description, double price) throws ServiceException;

    Book getBook(String idBook) throws ServiceException, DAOException;

    List<Book> findBookByName(String nameBook) throws ServiceException;

    List<Book> findBookByAuthor(String authorBook) throws ServiceException;

    List<Book> findBookByGenre(String genre) throws ServiceException;

    List<Book> sortBookByName(String nameBook) throws ServiceException;

    List<Book> sortBookByDate(String date) throws ServiceException;

    List<Book> sortBookByRating(String averageMark) throws ServiceException;
}
