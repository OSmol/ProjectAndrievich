package library.service.impl.sql;

import library.bean.Book;
import library.dao.exception.DAOException;
import library.service.BookService;
import library.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.List;

public class SQLBookServiceImpl implements BookService {
    private static Logger logger = Logger.getLogger(SQLBookServiceImpl.class);



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
