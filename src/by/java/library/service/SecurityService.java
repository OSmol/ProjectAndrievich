package library.service;

import library.bean.User;
import library.service.exception.ServiceException;

public interface SecurityService {
    void signIn(String login, String password) throws ServiceException;

    void signOut(String login) throws ServiceException;

    void registration(User user) throws ServiceException;
}
