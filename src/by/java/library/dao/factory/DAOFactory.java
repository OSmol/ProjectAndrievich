package library.dao.factory;

import library.dao.BookDAO;

import library.dao.UserDAO;

import library.dao.impl.SQLBookDAO;
import library.dao.impl.SQLUserDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final BookDAO sqlBookDAO = new SQLBookDAO();
    private final UserDAO sqlUserDAO = new SQLUserDAO();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public BookDAO getSqlBookImpl() {
        return sqlBookDAO;
    }

    public UserDAO getSqlUserDao() {
        return sqlUserDAO;
    }
}
