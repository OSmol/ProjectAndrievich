package library.service;

import library.bean.User;
import library.service.exception.ServiceException;

public interface UserService {
    void signIn(String login, char[] password) throws ServiceException;

    void signOut(String login) throws ServiceException;

    void registration(User user) throws ServiceException;
}
