package library.controller.command.impl;

import library.bean.User;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.UserService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class GetUserCommand implements Command {
    private static Logger logger = Logger.getLogger(GetUserCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();


    @Override
    public Response execute(Request request) {
        String login = String.valueOf(request.getBody().get("login"));
        String password = String.valueOf(request.getBody().get("password"));
        Response response = new Response();
        if (StringUtils.isAnyEmpty(login, password)) {
            response.setErrorMessage("Empty fields to add User");
            response.setResponseCode(400);
            return response;
        }


        try {
            User user = new User();
            UserService userService = serviceFactory.getUserServiceImpl();
            userService.getUser(user.getLogin());
            response.setResponseCode(201);
            return response;

        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}
