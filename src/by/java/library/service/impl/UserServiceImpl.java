package library.service.impl;

import library.bean.User;
import library.dao.UserDAO;
import library.dao.exception.DAOException;
import library.dao.factory.DAOFactory;
import library.service.UserService;
import library.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    private DAOFactory daoFactory = DAOFactory.getInstance();

    private static UserServiceImpl instance;

    private UserServiceImpl() {
    }

    public static synchronized UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public void delete(String login) throws ServiceException {
        logger.debug("UserServiceImpl.deleteUser - run");
        try {
            daoFactory.getTxtUserDAO().delete(login);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("UserServiceImpl.deleteUserByLogin - User deleted");
        }
    }

    @Override
    public void deleteUser(User user) throws ServiceException {
        logger.debug("UserServiceImpl.deleteUser - run");
        try {
            logger.debug("UserServiceImpl.deleteUser - User deleted");
            daoFactory.getTxtUserDAO().deleteUser(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getUsers() throws ServiceException {
        logger.debug("UserServiceImpl.getUsers - run");
        try {
            logger.debug("UserServiceImpl.getUsers - Users got");
            return daoFactory.getTxtUserDAO().getUsers();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User getUser(String login) throws ServiceException {
        logger.debug("UserServiceImpl.getUser - run");
        try {
            logger.debug("UserServiceImpl.getUser - User got");
            return daoFactory.getTxtUserDAO().getUser(login);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public void addUser(User user) throws ServiceException {
        logger.debug("UserServiceImpl.addUser - run");
        UserDAO txtUserDAO = daoFactory.getTxtUserDAO();
        try {
            txtUserDAO.add(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        logger.debug("UserServiceImpl.addUser - User add");
    }

    @Override
    public User findUserByLoginAndPassword(String login, String password) throws ServiceException {
        logger.debug("UserServiceImpl.findUserByLoginAndPassword - run");
        try {
            List<User> list = daoFactory.getTxtUserDAO().getUsers();
            for (User user : list) {
                String loginUser = user.getLogin();
                String passwordUser = user.getPassword();
                if (loginUser.equalsIgnoreCase(login) && passwordUser.equals(password)) {
                    return user;
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("UserServiceImpl.findUserByLoginAndPassword - User found");
        }
        return null;
    }

    @Override
    public User findUserByLogin(String login) throws ServiceException {
        logger.debug("UserServiceImpl.findUserByLogin - run");
//"что-нибудь".equals(login) - не вызовет NullPointer. тк всегда существует
        try {
            User user = daoFactory.getTxtUserDAO().getUser(login);
            if (user != null) {
                String loginUser = user.getLogin();
                if (login.equalsIgnoreCase(loginUser)) {
                    return (user);
                } else {
                    addUser(user);
                }
            } else {
                throw new ServiceException("Cant find user by this login " + login);
            }
            return user;
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("UserServiceImpl.findUserByLogin - User found");
        }
    }
}
