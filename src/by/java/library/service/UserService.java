package library.service;


import library.bean.User;
import library.service.exception.ServiceException;

import java.util.List;

public interface UserService {

    void delete(String login) throws ServiceException;

    List<User> getUsers() throws ServiceException;

    void addUser(User user) throws ServiceException;
}
