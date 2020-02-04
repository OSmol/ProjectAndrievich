package library.controller.command.impl;

import library.bean.Email;
import library.bean.User;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.SecurityService;
import library.service.UserService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import library.service.impl.SecurityServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class RegistrationCommand implements Command {
    private static Logger logger = Logger.getLogger(RegistrationCommand.class);
    private UserService userService = ServiceFactory.getInstance().getUserServiceImpl();
    private SecurityService securityService = new SecurityServiceImpl();

    @Override
    public Response execute(Request request) {
        String login = request.getStringValue("login");
        String password = request.getStringValue("password");
        // PasswordValidator.matchPassword(security.getPassword());
        String name = request.getStringValue("name");
        String email = request.getStringValue("email");
        String locale = request.getStringValue("locale");
        String userRole = request.getStringValue("userRole");

        Response response = new Response();
        if (StringUtils.isAnyEmpty(login, password, name, email, locale)) {
            response.setErrorMessage("Empty fields");
            response.setResponseCode(400);
            return response;
        }

        User user = new User();
        try {
            user.setLogin(login);
            user.setPassword(password);
            user.setName(name);
            user.setEmail(new Email(email));
            user.setLocale(locale);
            user.setUserRole(User.UserRole.ADMIN);

            securityService.registration(user);
            response.setResponseCode(201);
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(401);//unauthorized
        }
        return response;
    }
}


