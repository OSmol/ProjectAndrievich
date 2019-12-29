package library.dao.factory;

import library.dao.BookDAO;

import library.dao.CountryDAO;
import library.dao.GenreDAO;
import library.dao.UserDAO;

import library.dao.impl.sql.SQLBookDAOImpl;
import library.dao.impl.sql.SQLCountryDAOImpl;
import library.dao.impl.sql.SQLGenreDAOImpl;
import library.dao.impl.sql.SQLUserDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final BookDAO sqlBookDAOImpl = new SQLBookDAOImpl();
    private final UserDAO sqlUserDAOImpl = new SQLUserDAOImpl();
    private final CountryDAO sqlCountryDAOImpl = new SQLCountryDAOImpl();
    private final GenreDAO sqlGenreDAOImpl = new SQLGenreDAOImpl();

    private DAOFactory(){}

    public static DAOFactory getInstance() {
        return instance;
    }

    public BookDAO getSqlBookDAOImpl() {
        return sqlBookDAOImpl;
    }

    public UserDAO getSqlUserDAOImpl() {
        return sqlUserDAOImpl;
    }

    public CountryDAO getSqlCountryDAOImpl() {
        return sqlCountryDAOImpl;
    }

    public GenreDAO getSqlGenreDAOImpl() {
        return sqlGenreDAOImpl;
    }
}
