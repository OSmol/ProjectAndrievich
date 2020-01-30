package library.controller.command.impl;

import library.bean.User;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

public class DeleteUserCommand implements Command {
    private static Logger logger = Logger.getLogger(DeleteUserCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Response execute(Request request) {
        User user = (User) request.getBody().get("user");

        Response response = new Response();
        try {
            serviceFactory.getUserServiceImpl().deleteUser(user);
            response.setResponseCode(201);
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
        }
        return response;
    }
}
