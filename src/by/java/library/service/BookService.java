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

// преобразование типов в контроллере
    void addBook(Book book) throws ServiceException;

    void updateBook(Book book) throws ServiceException;

    Book getBook(int idBook) throws ServiceException;

    List<Book> findBookByName(String nameBook) throws ServiceException;

    List<Book> findBookByAuthor(String authorBook) throws ServiceException;

    List<Book> findBookByGenre(Genre genre) throws ServiceException;

    List<Book> sortBookByName(String nameBook) throws ServiceException;

    List<Book> sortBookByDate(String date) throws ServiceException;

    List<Book> sortBookByRating(String averageMark) throws ServiceException;
}
