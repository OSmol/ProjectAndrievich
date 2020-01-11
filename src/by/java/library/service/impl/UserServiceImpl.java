package library.service.impl;

import library.bean.User;
import library.dao.UserDAO;
import library.dao.exception.DAOException;
import library.dao.factory.DAOFactory;
import library.service.UserService;
import library.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.Map;

public class UserServiceImpl implements UserService {
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
    public void registration(Map<String, String> map) throws ServiceException {
        logger.debug("UserServiceImpl.registration()");
        User user = new User();
        UserDAO userDAO = daoFactory.getTxtUserDAO();
        try {
            //user =
            userDAO.registration(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        logger.debug("UserServiceImpl.registration()");
    }
}
