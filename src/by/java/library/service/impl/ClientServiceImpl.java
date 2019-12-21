package library.service.impl;

import library.bean.User;
import library.service.ClientService;
import library.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {

    @Override
    public void singIn(String login, char[] password) throws ServiceException {
        //проверяем параметры
        if (login==null || login.isEmpty()){
            throw new ServiceException("Incorrect login");
    }
}

    @Override
    public void singOut(String login) throws ServiceException {

    }

    @Override
    public void registration(User user) throws ServiceException {

    }
}
