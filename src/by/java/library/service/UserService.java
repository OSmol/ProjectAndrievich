package library.service;


import library.bean.User;
import library.service.exception.ServiceException;

import java.util.List;

public interface UserService {

    void delete(String login) throws ServiceException;

    void deleteUser(User user) throws ServiceException;

    List<User> getUsers() throws ServiceException;

    public User getUser(String login) throws ServiceException;

    void addUser(User user) throws ServiceException;

    User findUserByLoginAndPassword(String login, String password) throws ServiceException;

    User findUserByLogin(String login) throws ServiceException;


}
