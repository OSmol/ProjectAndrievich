package library.service.impl;

import library.bean.Email;
import library.bean.Letter;
import library.dao.factory.DAOFactory;
import library.service.LetterService;
import library.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.List;

public class LetterServiceImpl implements LetterService {
    private static Logger logger = Logger.getLogger(LetterServiceImpl.class);
    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private static LetterServiceImpl instance;

    private LetterServiceImpl() {
    }

    public static synchronized LetterServiceImpl getInstance() {
        if (instance == null) {
            instance = new LetterServiceImpl();
        }
        return instance;
    }

    public List<Letter> getAll() throws ServiceException {
        logger.debug("LetterServiceImpl - run");
        return daoFactory.getTxtLetterDAO().getAll();
    }
}
