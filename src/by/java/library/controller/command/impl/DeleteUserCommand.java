package library.controller.command.impl;

import library.bean.User;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.SecurityService;
import library.service.UserService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.Map;

public class DeleteUserCommand implements Command {
    private static Logger logger = Logger.getLogger(SignInCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private User.Security security = new User.Security();


    @Override
    public Response execute(Request request) {
        String login = String.valueOf(request.getBody().get("login"));
        String password = String.valueOf(request.getBody().get("password"));
        Response response = new Response();
        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            response.setErrorMessage("Enter login and password");
            response.setResponseCode(403);
            return response;
        }
        security.setLogin(login);
        security.setPassword(password);

        UserService userService = serviceFactory.getUserServiceImpl();
        userService.delete();
        response.setResponseCode(201);
        return response;

    }
}
