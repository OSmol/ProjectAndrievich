package library.service.impl;

import library.bean.*;
import library.dao.BookDAO;
import library.dao.exception.DAOException;
import library.dao.factory.DAOFactory;
import library.service.BookService;
import library.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookServiceImpl implements BookService {
    private static Logger logger = Logger.getLogger(BookServiceImpl.class);
    private final DAOFactory daoFactory = DAOFactory.getInstance();


    //передать бин
    @Override
    public void addBook(Book book) throws ServiceException {
        logger.debug("BookServiceImpl.addMovie - run");
        BookDAO txtBookDAO = daoFactory.getTxtBookDAO();
        BookDAO sqlBookDAO = daoFactory.getSqlBookDAO();
        try {
            txtBookDAO.addBook(book);
            sqlBookDAO.addBook(book);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        logger.debug("BookServiceImpl.addMovie - Book add");
    }

    @Override
    public void updateBook(Book book) throws ServiceException {
        logger.debug("BookServiceImpl.updateBook - run");
        BookDAO txtBookDAO = daoFactory.getTxtBookDAO();
        BookDAO sqlBookDAO = daoFactory.getSqlBookDAO();
        try {
            txtBookDAO.updateBook(book);
            sqlBookDAO.updateBook(book);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        logger.debug("BookServiceImpl.updateMovie - Book updated");
    }


    @Override
    public Book getBook(int idBook) throws ServiceException {
        logger.debug("BookServiceImpl.getBook - run");
        try {
            return daoFactory.getTxtBookDAO().getBook(idBook);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Book> findBookByName(String nameBook) throws ServiceException {
        List<Book> list = new ArrayList<>();
        for (Book book : list) {
            String nameOfBook = book.getTitle();
            if (nameOfBook.equalsIgnoreCase(nameBook)) {
                list.add(book);
            }
        }
        return list;
    }

    @Override
    public List<Book> findBookByAuthor(String authorBook) throws ServiceException {
        List<Book> list = new ArrayList<>();
        for (Book book : list) {
            String authorNameBook = String.valueOf(book.getAuthor());
            if (authorNameBook.equalsIgnoreCase(authorBook)) {
                list.add(book);
            }
        }
        return list;
    }


    @Override
    public List<Book> findBookByGenre(Genre genre) throws ServiceException {
        List<Book> list = new ArrayList<>();
       for (Book book:list) {
               String genreName = String.valueOf(book.getGenres());
        if (Objects.equals(genreName, genre)) {
            list.add(book);
        }
       }
        return list;
    }


    @Override
    public List<Book> sortBookByName(String nameBook) throws ServiceException {
        List<Book> list = null;


        return list;

    }

    @Override
    public List<Book> sortBookByDate(String date) throws ServiceException {
        return null;
    }

    @Override
    public List<Book> sortBookByRating(String averageMark) throws ServiceException {
        return null;
    }
}
