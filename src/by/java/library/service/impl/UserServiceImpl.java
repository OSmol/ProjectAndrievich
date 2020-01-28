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

    @Override
    public void signIn(String login, String password) throws ServiceException {
        //проверяем параметры
        if (login == null || login.isEmpty()) {
            throw new ServiceException("Incorrect login");
        }
    }

    @Override
    public void signOut(String login) {

    }

    @Override
    public void registration(User.Security security) throws ServiceException {
        logger.debug("UserServiceImpl.registration() - run");
        User user = new User();
        UserDAO userDAO = daoFactory.getTxtUserDAO();
        try {
            userDAO.add(user);
            //  PasswordValidator.isEmptyString(security.getPassword());
            // PasswordValidator.matchPassword(security.getPassword());
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("UserServiceImpl.registration() - User add");
        }
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
                if (loginUser.equalsIgnoreCase(login)&&passwordUser.equals(password)) {
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
        try {
            List<User> list = daoFactory.getTxtUserDAO().getUsers();
            for (User user : list) {
                String loginUser = user.getLogin();
                if (loginUser.equalsIgnoreCase(login)) {
                    return user;
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("UserServiceImpl.findUserByLogin - User found");
        }
        return null;
    }
}
