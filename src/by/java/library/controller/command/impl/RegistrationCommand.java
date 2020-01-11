package library.controller.command.impl;

import library.bean.User;
import library.controller.command.Command;
import library.service.SecurityService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.Map;

public class RegistrationCommand implements Command {
    private static Logger logger = Logger.getLogger(RegistrationCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private User.Security security = new User.Security();

    @Override
    public Map<Object, Object> execute(Map<String, String> parameters) throws ServiceException {
        String login = parameters.get("login");
        String password = parameters.get("password");

        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            System.out.println("Enter login and password");
        }
        security.setLogin(login);
        security.setPassword(password);

//создать эксепшен
        try {
            SecurityService securityService = serviceFactory.getUserServiceImpl();
            securityService.registration(security);

        } catch (ServiceException e) {
            throw new ServiceException(e);
        }
        return null;
    }
}


