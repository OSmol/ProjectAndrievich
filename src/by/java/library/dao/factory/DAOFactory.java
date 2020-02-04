package library.dao.factory;

import library.dao.impl.sql.SQLBookDAOImpl;
import library.dao.impl.sql.SQLPersonDAOImpl;
import library.dao.impl.sql.SQLUserDAOImpl;
import library.dao.impl.txt.*;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final SQLBookDAOImpl sqlBookDAO = new SQLBookDAOImpl();
    private final SQLUserDAOImpl sqlUserDAO = new SQLUserDAOImpl();
    private final SQLPersonDAOImpl sqlPersonDAO = new SQLPersonDAOImpl();
    private final TxtBookDAOImpl txtBookDAO = TxtBookDAOImpl.getInstance();
    private final TxtUserDAOImpl txtUserDAO = TxtUserDAOImpl.getInstance();
    private final TxtPersonDAOImpl txtPersonDAO = new TxtPersonDAOImpl();
    private final TxtEmailDAOImpl txtEmailDAO = new TxtEmailDAOImpl();
    private final TxtLetterDAOImpl txtLetterDAO = new TxtLetterDAOImpl();


    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public SQLBookDAOImpl getSqlBookDAO() {
        return sqlBookDAO;
    }

    public SQLUserDAOImpl getSqlUserDAO() {
        return sqlUserDAO;
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


    public TxtPersonDAOImpl getTxtPersonDAO() {
        return txtPersonDAO;
    }

    public TxtEmailDAOImpl getTxtEmailDAO() {
        return txtEmailDAO;
    }

    public TxtLetterDAOImpl getTxtLetterDAO() {
        return txtLetterDAO;
    }


}
