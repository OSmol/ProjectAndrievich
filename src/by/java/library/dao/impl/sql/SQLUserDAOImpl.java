package library.dao.impl.sql;

import library.bean.User;
import library.dao.UserDAO;
import library.dao.exception.DAOException;

import java.util.List;

public class SQLUserDAOImpl implements UserDAO {



    @Override
    public List<User> getAll() throws DAOException {
        return null;
    }

    @Override
    public boolean add(User user) throws DAOException {

        return false;
    }

    @Override
    public void delete(String login) throws DAOException {

    }

    @Override
    public boolean delete(User user) throws DAOException {

        return false;
    }

    @Override
    public User get(String login) throws DAOException {
        return null;
    }

    @Override
    public void update(User user) throws DAOException {

    }
}
