package library.dao;

import library.bean.User;
import library.dao.exception.DAOException;

public interface UserDAO {
    void signIn(String login, String password) throws DAOException;
    void registration (User user) throws DAOException;
}
