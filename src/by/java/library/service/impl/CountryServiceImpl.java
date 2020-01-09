package library.service.impl;

import library.bean.Country;
import library.dao.CountryDAO;
import library.dao.exception.DAOException;
import library.dao.factory.DAOFactory;
import library.service.CountryService;
import library.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.List;

public class CountryServiceImpl implements CountryService {
    private static Logger logger = Logger.getLogger(BookServiceImpl.class);
    private final DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public List<Country> getAll() throws ServiceException {
        logger.debug("CountryServiceImpl.getCountry - run");
        try {
            return daoFactory.getTxtCountryDAO().getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
