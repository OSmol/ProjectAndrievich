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

    public List<Email> getAll() throws ServiceException {
        logger.debug("EmailServiceImpl - run");
        return daoFactory.getTxtEmailDAO().getAll();
    }
}
