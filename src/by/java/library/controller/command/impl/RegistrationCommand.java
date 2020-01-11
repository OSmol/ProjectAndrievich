package library.controller.command.impl;

import library.bean.Security;
import library.bean.User;
import library.controller.command.Command;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.Map;

public class RegistrationCommand implements Command {
    private static Logger logger = Logger.getLogger(RegistrationCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private Security security = new Security();

    @Override
    public Map<Object, Object> execute(Map<String, String> parameters) throws ServiceException {
        String login = parameters.get("login");
        String password = parameters.get("password");
        security.setLogin(String.valueOf(login));
        security.setPassword(String.valueOf(password));


      //  if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
       //     System.out.println("Enter login and password");
      //  }
      /*  try {
            UserService userService = serviceFactory.getUserServiceImpl();
            User user = userService.registration(User.Role.USER);

        } catch (ServiceException e) {
            throw new ServiceException(e);
        }*/
        return null;
    }
}


