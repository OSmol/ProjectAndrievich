package library.controller.command.impl;

import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.UserService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

public class GetUserByLoginCommand implements Command {
    private static Logger logger = Logger.getLogger(GetUserByLoginCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();


    @Override
    public Response execute(Request request) {
        Response response = new Response();
        UserService userService = serviceFactory.getUserServiceImpl();
        try {
            String login = request.getStringValue("login");
            response.getBody().put("user", userService.getUser(login));
            response.setResponseCode(201);
            return response;
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}
