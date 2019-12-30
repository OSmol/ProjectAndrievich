package library.service.impl;

import library.bean.Book;
import library.dao.exception.DAOException;
import library.service.BookService;
import library.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.List;

public class BookServiceImpl implements BookService {
    private static Logger logger = Logger.getLogger(BookServiceImpl.class);

    @Override
    public void addBook(Book book)
            throws ServiceException {

    }

    @Override
    public void addBooks(List<Book> books) throws ServiceException {

    }


    @Override
    public void editBook(int id, String title, String author, String publishingHouse,
                         int year, String[] genresID, String[] countriesID, long isbn,
                         int countOfPages, String language, String authorOfTranslation,
                         String description, String averageMark, String customer, double price)
            throws ServiceException {

    }

    @Override
    public List<Book> findBookByName(String nameBook) throws DAOException {
        return null;
    }

    @Override
    public List<Book> findBookByAuthor(String authorBook) throws DAOException {
        return null;
    }

    @Override
    public List<Book> findBookByGenre(String genre) throws DAOException {
        return null;
    }

    @Override
    public List<Book> sortBookByName(String nameBook) throws DAOException {
        return null;
    }

    @Override
    public List<Book> sortBookByDate(String date) throws DAOException {
        return null;
    }

    @Override
    public List<Book> sortBookByRating(String averageMark) throws DAOException {
        return null;
    }
}
