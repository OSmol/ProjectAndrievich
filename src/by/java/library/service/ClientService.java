package library.service;

import library.bean.User;
import library.service.exception.ServiceException;

public interface ClientService {
    void singIn(String login, char[]password)throws ServiceException;
void singOut (String login) throws ServiceException;
void registration(User user) throws ServiceException;
}
