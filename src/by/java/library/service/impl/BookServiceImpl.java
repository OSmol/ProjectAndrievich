package library.service.impl;

import library.bean.Book;
import library.dao.BookDAO;
import library.dao.exception.DAOException;
import library.dao.factory.DAOFactory;
import library.service.BookService;
import library.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    private static Logger logger = Logger.getLogger(BookServiceImpl.class);
    private final DAOFactory daoFactory = DAOFactory.getInstance();


    @Override
    public void addBook(Book book) throws ServiceException {
        logger.debug("BookServiceImpl.addBook - run");
        BookDAO txtBookDAO = daoFactory.getTxtBookDAO();
        try {
            txtBookDAO.addBook(book);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        logger.debug("BookServiceImpl.addBook - Book add");
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
            logger.debug("BookServiceImpl.updateBook - Book got");
            return daoFactory.getTxtBookDAO().getBook(idBook);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public List<Book> getBooks() throws ServiceException {
        logger.debug("BookServiceImpl.getBooks - run");
        try {
            logger.debug("BookServiceImpl.getBooks - Book got");
            return daoFactory.getTxtBookDAO().getBooks();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteBook(Book book) throws ServiceException {
        logger.debug("BookServiceImpl.deleteBook - run");
        try {
            logger.debug("BookServiceImpl.deleteBook - Book deleted");
            daoFactory.getTxtBookDAO().deleteBook(book);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public List<Book> findBookByName(String nameBook) throws ServiceException {
        logger.debug("BookServiceImpl.findBookByName - run");
        List<Book> listBooksByName = new ArrayList<>();
        try {
            List<Book> list = daoFactory.getTxtBookDAO().getBooks();
            for (Book book : list) {
                String title = book.getTitle();
                if (title.equalsIgnoreCase(nameBook)) {
                    listBooksByName.add(book);
                                    }
            }
            return listBooksByName;
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("BookServiceImpl.findBookByName - Book found");
        }
    }

    @Override
    public List<Book> findBookByAuthor(String authorBook) throws ServiceException {
        logger.debug("BookServiceImpl.findBookByAuthor - run");
        List<Book> listBooksByAuthor = new ArrayList<>();
        try {
            List<Book> list = daoFactory.getTxtBookDAO().getBooks();
            for (Book book : list) {
                String author = book.getAuthor();
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
    public List<Book> findBookByGenre(String genre) throws ServiceException {
        logger.debug("BookServiceImpl.findBookByGenre - run");
        List<Book> listBooksByGenre = new ArrayList<>();
        try {
            List<Book> list = daoFactory.getTxtBookDAO().getBooks();
            for (Book book : list) {
                String genreName = book.getGenre();
                if (genre.equalsIgnoreCase(genreName)) {
                    listBooksByGenre.add(book);
                    return listBooksByGenre;
                } else {
                    logger.debug("BookServiceImpl.findBookByGenre - Book not found");
                }
            }
            return listBooksByGenre;
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("BookServiceImpl.findBookByGenre - Book found");
        }
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
        } finally {
            logger.debug("BookServiceImpl.sortBookByName - Book sort");
        }
    }


    @Override
    public List<Book> sortBookByYear() throws ServiceException {
        logger.debug("BookServiceImpl.sortBookByYear - run");
        List<Book> list;
        try {
            list = daoFactory.getTxtBookDAO().getBooks();
            list.sort(new Book.YearComparator());
            return list;
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("BookServiceImpl.sortBookByYear - Book sort");
        }
    }

    @Override
    public List<Book> sortBookByRating(double averageMark) {
        return null;
    }

    @Override
    public void deleteBookById(int id) throws ServiceException {
        logger.debug("BookServiceImpl.deleteBookById - run");
        try {
            daoFactory.getTxtBookDAO().deleteBook(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("BookServiceImpl.deleteBookById - Book deleted");
        }
    }
}
