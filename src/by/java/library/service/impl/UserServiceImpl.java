package library.service.impl;

import library.bean.User;
import library.dao.UserDAO;
import library.dao.exception.DAOException;
import library.dao.factory.DAOFactory;
import library.service.SecurityService;
import library.service.UserService;
import library.service.exception.ServiceException;
import org.apache.log4j.Logger;

public class UserServiceImpl implements SecurityService, UserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    private DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public void signIn(String login, char[] password) throws ServiceException {
        //проверяем параметры
        if (login == null || login.isEmpty()) {
            throw new ServiceException("Incorrect login");
        }
    }

    @Override
    public void signOut(String login) throws ServiceException {

    }

    @Override
    public void registration(User.Security security) throws ServiceException {
        logger.debug("UserServiceImpl.registration()");
        User user = new User(security);
        UserDAO userDAO = daoFactory.getTxtUserDAO();
        try {
            userDAO.add(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("UserServiceImpl.registration()");
        }
    }

    @Override
    public void delete() {

    }
}
