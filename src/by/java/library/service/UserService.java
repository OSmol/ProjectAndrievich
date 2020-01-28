package library.service;


import library.bean.User;
import library.service.exception.ServiceException;

import java.util.List;

public interface UserService {

    void delete(String login) throws ServiceException;

    List<User> getUsers() throws ServiceException;

    void addUser(User user) throws ServiceException;

    User findUserByLoginAndPassword(String login, String password) throws ServiceException;

    User findUserByLogin(String login) throws ServiceException;

    void signIn(String login, String password) throws ServiceException;

    void signOut(String login) throws ServiceException;

    void registration(User.Security security) throws ServiceException;
}
