package library.dao.impl.txt;

import library.bean.Email;
import library.dao.EmailDAO;
import library.dao.factory.DAOFactory;
import library.service.exception.ServiceException;
import library.service.impl.BookServiceImpl;
import library.service.impl.PersonServiceImpl;
import org.apache.log4j.Logger;

import java.util.List;

public class TxtEmailDAOImpl implements EmailDAO {
    private static Logger logger = Logger.getLogger(BookServiceImpl.class);
    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private static TxtEmailDAOImpl instance;

    private TxtEmailDAOImpl() {
    }

    public static synchronized TxtEmailDAOImpl getInstance() {
        if (instance == null) {
            instance = new TxtEmailDAOImpl();
        }
        return instance;
    }

    public List<Email> getAll() throws ServiceException {
        return null;
    }
}
