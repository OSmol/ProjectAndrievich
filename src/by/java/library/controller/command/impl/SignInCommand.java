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

public class SignInCommand implements Command {
    private static Logger logger = Logger.getLogger(SignInCommand.class);
    private UserService userService = ServiceFactory.getInstance().getUserServiceImpl();

    @Override
    public Response execute(Request request) {
        String login = String.valueOf(request.getBody().get("login"));
        String password = String.valueOf(request.getBody().get("password"));
        Response response = new Response();
        if (StringUtils.isAnyEmpty(login, password)) {
            response.setErrorMessage("Empty fields");
            response.setResponseCode(400);
            return response;
        }
        PasswordEncryptor passwordEncryptor = new PasswordEncryptorImpl();
        String encryptedPassword = passwordEncryptor.encrypt(password);//зашифровать
        User user = null;
        try {
            user = userService.findUserByLoginAndPassword(login, encryptedPassword);
        } catch (ServiceException e) {
            //
        }
        if (user != null) {
            SecurityContextHolder.setLoggedUser(user);
            response.setResponseCode(201);
        }
        if (user == null) {
            response.setResponseCode(403);//
            response.setErrorMessage("Not found user");
        }
        return response;
    }
}
