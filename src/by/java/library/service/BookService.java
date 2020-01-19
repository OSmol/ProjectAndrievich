package library.service;

import library.bean.Book;
import library.service.exception.ServiceException;

import java.util.List;

public interface BookService {

// преобразование типов в контроллере
    void addBook(Book book) throws ServiceException;

    void updateBook(Book book) throws ServiceException;

    Book getBook(int idBook) throws ServiceException;

    void deleteBook(Book book) throws ServiceException;

    List<Book> findBookByName(String nameBook) throws ServiceException;

    List<Book> findBookByAuthor(String authorBook) throws ServiceException;

    List<Book> findBookByGenre(String genre) throws ServiceException;

    List<Book> sortBookByName() throws ServiceException;

    List<Book> sortBookByYear() throws ServiceException;

    List<Book> sortBookByRating(double averageMark) throws ServiceException;


}
