package library.dao.impl.txt;

import library.bean.User;
import library.dao.UserDAO;
import library.dao.exception.DAOException;

public class TxtUserDAOImpl implements UserDAO {

    @Override
    public void signIn(String login, String password) throws DAOException {

    }

    @Override
    public void registration(User user) throws DAOException {

    }

    @Override
    public void signUp(User user) throws DAOException {

    }

    @Override
    public void blockedUser(int id) throws DAOException {

    }

    @Override
    public void unblockedUser(int id) throws DAOException {

    }

    @Override
    public void findUser(String login) throws DAOException {

    }

    @Override
    public void setUserAccess(int id) throws DAOException {

    }

    @Override
    public void setAdminAccess(int id) throws DAOException {

    }
}
