package library.dao.factory;

import library.dao.impl.sql.*;
import library.dao.impl.txt.*;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final SQLBookDAOImpl sqlBookDAO = new SQLBookDAOImpl();
    private final SQLUserDAOImpl sqlUserDAO = new SQLUserDAOImpl();
    private final SQLCountryDAOImpl sqlCountryDAO = new SQLCountryDAOImpl();
    private final SQLGenreDAOImpl sqlGenreDAO = new SQLGenreDAOImpl();
    private final SQLPersonDAOImpl sqlPersonDAO = new SQLPersonDAOImpl();

    private final TxtBookDAOImpl txtBookDAO = new TxtBookDAOImpl();
    private final TxtUserDAOImpl txtUserDAO = new TxtUserDAOImpl();
    private final TxtCountryDAOImpl txtCountryDAO = new TxtCountryDAOImpl();
    private final TxtGenreDAOImpl txtGenreDAO = new TxtGenreDAOImpl();
    private final TxtPersonDAOImpl txtPersonDAO = new TxtPersonDAOImpl();
    private final TxtEmailDAOImpl txtEmailDAO = new TxtEmailDAOImpl();
    private final TxtLetterDAOImpl txtLetterDAO = new TxtLetterDAOImpl();
    private final TxtLibraryDAOImpl txtLibraryDAO= new TxtLibraryDAOImpl();


    private DAOFactory(){}

    public static DAOFactory getInstance() {
        return instance;
    }

    public SQLBookDAOImpl getSqlBookDAO() {
        return sqlBookDAO;
    }

    public SQLUserDAOImpl getSqlUserDAO() {
        return sqlUserDAO;
    }

    public SQLCountryDAOImpl getSqlCountryDAO() {
        return sqlCountryDAO;
    }

    public SQLGenreDAOImpl getSqlGenreDAO() {
        return sqlGenreDAO;
    }

    public SQLPersonDAOImpl getSqlPersonDAO() {
        return sqlPersonDAO;
    }

    public TxtBookDAOImpl getTxtBookDAO() {
        return txtBookDAO;
    }

    public TxtUserDAOImpl getTxtUserDAO() {
        return txtUserDAO;
    }

    public TxtCountryDAOImpl getTxtCountryDAO() {
        return txtCountryDAO;
    }

    public TxtGenreDAOImpl getTxtGenreDAO() {
        return txtGenreDAO;
    }

    public TxtPersonDAOImpl getTxtPersonDAO() {
        return txtPersonDAO;
    }

    public TxtEmailDAOImpl getTxtEmailDAO() {
        return txtEmailDAO;
    }

    public TxtLetterDAOImpl getTxtLetterDAO() {
        return txtLetterDAO;
    }

    public TxtLibraryDAOImpl getTxtLibraryDAO() {
        return txtLibraryDAO;
    }
}
