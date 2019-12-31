package library.dao.impl.sql;

import library.bean.Book;
import library.dao.BookDAO;
import library.dao.exception.DAOException;
import library.service.impl.BookServiceImpl;
import org.apache.log4j.Logger;

import java.io.*;

public class SQLBookDAOImpl implements BookDAO {
    private static Logger logger = Logger.getLogger(BookServiceImpl.class);


    @Override
    public void addBook(Book book) throws DAOException {

    }

    @Override
    public void deleteBook(long idBook) throws DAOException {

    }

    @Override
    public void deleteBook(Book book) throws DAOException {

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
