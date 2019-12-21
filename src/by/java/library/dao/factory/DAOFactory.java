package library.dao.factory;

import library.dao.BookDAO;

import library.dao.UserDAO;

import library.dao.impl.SQLBookDAO;
import library.dao.impl.SQLUserDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final BookDAO sqlBookImpl = new SQLBookDAO();
    private final UserDAO sqlUserDao = new SQLUserDAO();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public BookDAO getSqlBookImpl() {
        return sqlBookImpl;
    }

    public UserDAO getSqlUserDao() {
        return sqlUserDao;
    }
}
