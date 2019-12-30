package library.dao.factory;

import library.dao.*;

import library.dao.impl.sql.*;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final BookDAO sqlBookDAOImpl = new SQLBookDAOImpl();
    private final UserDAO sqlUserDAOImpl = new SQLUserDAOImpl();
    private final CountryDAO sqlCountryDAOImpl = new SQLCountryDAOImpl();
    private final GenreDAO sqlGenreDAOImpl = new SQLGenreDAOImpl();
    private final PersonDAO sqlpersonDAOImpl = new SQLPersonDAOImpl();

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

    public PersonDAO getSqlpersonDAOImpl(){
        return sqlpersonDAOImpl;
    }
}
