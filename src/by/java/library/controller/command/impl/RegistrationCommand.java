package library.controller.command.impl;

import library.bean.User;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.security.PasswordEncryptor;
import library.security.PasswordEncryptorImpl;
import library.security.SecurityContextHolder;
import library.service.UserService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class RegistrationCommand implements Command {
    private static Logger logger = Logger.getLogger(RegistrationCommand.class);
    private UserService userService = ServiceFactory.getInstance().getUserServiceImpl();

    @Override
    public Response execute(Request request) {
        String login = String.valueOf(request.getBody().get("login"));

        String password = String.valueOf(request.getBody().get("password"));
        String name = String.valueOf(request.getBody().get("name"));
        String email = String.valueOf(request.getBody().get("email"));
        String locale = String.valueOf(request.getBody().get("locale"));
        Response response = new Response();
        if (StringUtils.isAnyEmpty(login, password, name, email, locale)) {
            response.setErrorMessage("Empty fields");
            response.setResponseCode(400);
            return response;
        }
        PasswordEncryptor passwordEncryptor = new PasswordEncryptorImpl();
        String encryptedPassword = passwordEncryptor.encrypt(password);//зашифровать
        User user;
        try {
            user = userService.findUserByLogin(login);
            if (user != null) {
                response.setResponseCode(403);
                response.setErrorMessage("User with this login already exist");
            }
            if (user == null) {
                User user1 = new User();
                user1.setName(name);
                SecurityContextHolder.setLoggedUser(user1);
                response.setResponseCode(201);
                userService.addUser(user1);
            }
        } catch (ServiceException e) {
            //
        }
        return response;
    }
}


