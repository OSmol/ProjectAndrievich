package library.controller.command.impl;

import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.UserService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

public class DeleteUserByLoginCommand implements Command {
    private static Logger logger = Logger.getLogger(DeleteUserByLoginCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();


    @Override
    public Response execute(Request request) {
        Response response = new Response();
        try {
            String login = request.getStringValue("login");
            UserService userService = serviceFactory.getUserServiceImpl();
            userService.delete(login);
            return response;
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}
