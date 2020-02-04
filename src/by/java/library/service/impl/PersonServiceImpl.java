package library.service.impl;

import library.bean.Person;
import library.dao.exception.DAOException;
import library.dao.factory.DAOFactory;
import library.service.PersonService;
import library.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.List;

public class PersonServiceImpl implements PersonService {
    private static Logger logger = Logger.getLogger(BookServiceImpl.class);
    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private static PersonServiceImpl instance;

    private PersonServiceImpl() {
    }

    public static synchronized PersonServiceImpl getInstance() {
        if (instance == null) {
            instance = new PersonServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Person> getAll() throws ServiceException {
        logger.debug("PersonServiceImpl.getPerson - run");
        try {
            return daoFactory.getTxtPersonDAO().getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}

