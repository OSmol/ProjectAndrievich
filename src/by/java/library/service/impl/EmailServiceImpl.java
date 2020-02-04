package library.service.impl;

import library.bean.Email;
import library.dao.factory.DAOFactory;
import library.service.EmailService;
import library.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.List;

public class EmailServiceImpl implements EmailService {
    private static Logger logger = Logger.getLogger(EmailServiceImpl.class);
    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private static EmailServiceImpl instance;

    private EmailServiceImpl() {
    }

    public static synchronized EmailServiceImpl getInstance() {
        if (instance == null) {
            instance = new EmailServiceImpl();
        }
        return instance;
    }

    public List<Email> getAll() throws ServiceException {
        logger.debug("EmailServiceImpl - run");
        return daoFactory.getTxtEmailDAO().getAll();
    }
}
