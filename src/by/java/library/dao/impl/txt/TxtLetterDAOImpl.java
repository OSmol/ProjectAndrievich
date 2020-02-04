package library.dao.impl.txt;

import library.bean.Letter;
import library.dao.LetterDAO;
import library.dao.factory.DAOFactory;
import library.service.exception.ServiceException;
import library.service.impl.BookServiceImpl;
import org.apache.log4j.Logger;

import java.util.List;

public class TxtLetterDAOImpl implements LetterDAO {
    private static Logger logger = Logger.getLogger(BookServiceImpl.class);
    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private static TxtLetterDAOImpl instance;

    private TxtLetterDAOImpl() {
    }

    public static synchronized TxtLetterDAOImpl getInstance() {
        if (instance == null) {
            instance = new TxtLetterDAOImpl();
        }
        return instance;
    }

    public List<Letter> getAll() throws ServiceException {
        return null;
    }
}
