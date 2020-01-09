package library.service.impl;

import library.bean.*;
import library.dao.BookDAO;
import library.dao.exception.DAOException;
import library.dao.factory.DAOFactory;
import library.service.BookService;
import library.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.*;

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
            logger.debug("BookServiceImpl.updateMovie - Book got");
            return daoFactory.getTxtBookDAO().getBook(idBook);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public Book findBookByName(String nameBook) throws ServiceException {
        logger.debug("BookServiceImpl.findBookByName - run");
        try {
            List<Book> list = daoFactory.getTxtBookDAO().getBooks();
            for (Book book : list) {
                String title = String.valueOf(book.getAuthor());
                if (title.equalsIgnoreCase(nameBook)) {
                    logger.debug("BookServiceImpl.findBookByName - Book found");
                    return book;
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return null;
    }

    @Override
    public List<Book> findBookByAuthor(String authorBook) throws ServiceException {
        logger.debug("BookServiceImpl.findBookByName - run");
        List<Book> listBooksByAuthor = new ArrayList<>();
        try {
            List<Book> list = daoFactory.getTxtBookDAO().getBooks();
            for (Book book : list) {
                String author = book.getAuthor().getSurname();
                if (author.equalsIgnoreCase(authorBook)) {
                    listBooksByAuthor.add(book);
                }
            }
            return listBooksByAuthor;
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("BookServiceImpl.findBookByAuthor - Book found");
        }
    }


    @Override
    public List<Book> findBookByGenre(Genre genre) throws ServiceException {
        logger.debug("BookServiceImpl.findBookByGenre - run");
        List<Book> listBooksByGenre = new ArrayList<>();
        try {
            List<Book> list = daoFactory.getTxtBookDAO().getBooks();
            for (Book book : list) {
                for (Genre genreName : book.getGenres()) {
                    if (genre.getName().equalsIgnoreCase(genreName.getName())) {
                        listBooksByGenre.add(book);
                    } else {
                        logger.debug("BookServiceImpl.findBookByGenre - Book not found");
                    }
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        logger.debug("BookServiceImpl.findBookByGenre - Book found");
        return listBooksByGenre;
    }

    @Override
    public List<Book> sortBookByName() throws ServiceException {
        logger.debug("BookServiceImpl.sortBookByName - run");
        List<Book> list;
        try {
            list = daoFactory.getTxtBookDAO().getBooks();
            list.sort(new Book.NameComparator());
            return list;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        finally {
            logger.debug("BookServiceImpl.sortBookByName - Book sort");
        }
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
