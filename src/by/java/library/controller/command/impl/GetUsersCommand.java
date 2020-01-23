package library.controller.command.impl;

import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.UserService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

public class GetUsersCommand implements Command {
    private static Logger logger = Logger.getLogger(GetUsersCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Response execute(Request request) {//
        Response response = new Response();
        try {
            UserService userService = serviceFactory.getUserServiceImpl();
            response.setResponseCode(201);
            response.getBody().put("list", userService.getUsers());
            return response;

        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}
