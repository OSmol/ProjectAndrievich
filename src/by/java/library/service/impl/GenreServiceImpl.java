package library.service.impl;

import library.bean.Genre;
import library.dao.exception.DAOException;
import library.dao.factory.DAOFactory;
import library.service.GenreService;
import library.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.List;

public class GenreServiceImpl implements GenreService {
    private static Logger logger = Logger.getLogger(BookServiceImpl.class);
    private final DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public List<Genre> getAll() throws ServiceException {
        logger.debug("GenreServiceImpl.getGenre - run");
        try {
            return daoFactory.getTxtGenreDAO().getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}

