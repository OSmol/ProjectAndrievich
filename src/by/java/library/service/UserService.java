package library.service;

import library.bean.User;
import library.service.exception.ServiceException;

import java.util.Map;

public interface UserService {
    void signIn(String login, char[] password) throws ServiceException;

    void signOut(String login) throws ServiceException;

    void registration(Map<String,String> map) throws ServiceException;
}
