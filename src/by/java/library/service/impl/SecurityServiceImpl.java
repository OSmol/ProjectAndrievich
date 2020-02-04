package library.service.impl;

import library.bean.User;
import library.dao.UserDAO;
import library.dao.exception.DAOException;
import library.dao.factory.DAOFactory;
import library.security.PasswordEncryptor;
import library.security.PasswordEncryptorImpl;
import library.security.SecurityContextHolder;
import library.service.SecurityService;
import library.service.UserService;
import library.service.exception.ServiceException;
import org.apache.log4j.Logger;

public class SecurityServiceImpl implements SecurityService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    private DAOFactory daoFactory = DAOFactory.getInstance();
    private UserDAO userDAO = daoFactory.getTxtUserDAO();
    private UserService userService = UserServiceImpl.getInstance();

    private static SecurityServiceImpl instance;

    private SecurityServiceImpl() {
    }

    public static synchronized SecurityServiceImpl getInstance() {
        if (instance == null) {
            instance = new SecurityServiceImpl();
        }
        return instance;
    }
    @Override
    public void signIn(String login, String password) throws ServiceException {

        logger.debug("UserServiceImpl.registration() - run");
        try {
            PasswordEncryptor passwordEncryptor = new PasswordEncryptorImpl();
            User foundUser = userDAO.getUser(login);
            if (!foundUser.getPassword().equals(passwordEncryptor.encrypt(password))) {
                throw new ServiceException("don't find user by login and password.");
            }
            SecurityContextHolder.setLoggedUser(foundUser);//todo
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("UserServiceImpl.registration() - User add");
        }


    }

    @Override
    public void signOut(String login) {

    }

    @Override
    public void registration(User user) throws ServiceException {
        logger.debug("UserServiceImpl.registration() - run");
        try {
            PasswordEncryptor passwordEncryptor = new PasswordEncryptorImpl();
            user.setPassword(passwordEncryptor.encrypt(user.getPassword()));//зашифровали пароль
            User foundUser = userDAO.getUser(user.getLogin());
            if (foundUser != null) {
                throw new ServiceException("User with this login already exist");
            }
            //   SecurityContextHolder.setLoggedUser(user1);//todo
            userDAO.add(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("UserServiceImpl.registration() - User add");
        }
    }
}
