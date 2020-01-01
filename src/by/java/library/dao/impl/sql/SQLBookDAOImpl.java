package library.dao.impl.sql;

import library.bean.Book;
import library.dao.BookDAO;
import library.dao.exception.DAOException;
import library.service.impl.sql.SQLBookServiceImpl;
import org.apache.log4j.Logger;

public class SQLBookDAOImpl implements BookDAO {
    private static Logger logger = Logger.getLogger(SQLBookServiceImpl.class);


    @Override
    public void addBook(Book book) throws DAOException {

    }

    @Override
    public void deleteBook(int idBook) throws DAOException {

    }


    @Override
    public Book getBook(int idBook) throws DAOException {
        return null;
    }

    @Override
    public void getAllBooks(Book book) throws DAOException {

    }

    @Override
    public void updateBook(Book book) throws DAOException {

    }
}
