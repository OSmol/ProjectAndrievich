package library.service.impl.txt;

import library.bean.User;
import library.service.UserService;
import library.service.exception.ServiceException;

public class TxtUserServiceImpl implements UserService {

    @Override
    public void signIn(String login, char[] password) throws ServiceException {
        //проверяем параметры
        if (login==null || login.isEmpty()){
            throw new ServiceException("Incorrect login");
    }
}

    @Override
    public void signOut(String login) throws ServiceException {

    }

    @Override
    public void registration(User user) throws ServiceException {

    }
}
