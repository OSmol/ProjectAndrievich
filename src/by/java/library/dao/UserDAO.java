package library.dao;

import library.bean.User;
import library.dao.exception.DAOException;

public interface UserDAO {
    void signIn(String login, String password) throws DAOException;
    void registration (User user) throws DAOException;
    void signUp(User user) throws DAOException;
    void blockedUser(int id) throws DAOException;
    void unblockedUser(int id) throws DAOException;
    void findUser (String login) throws DAOException;
    void setUserAccess(int id) throws DAOException;
    void setAdminAccess(int id) throws DAOException;
}
