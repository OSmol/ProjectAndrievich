package library.controller.command.impl;

import library.bean.User;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.UserService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

public class DeleteUserCommand implements Command {
    private static Logger logger = Logger.getLogger(DeleteUserCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private User.Security security = new User.Security();


    @Override
    public Response execute(Request request) {
        Response response = new Response();
        try {
         //   System.out.println("Enter login user: ");
         //   String login = ScannerHelper.inputStringFromConsole();

            String login = String.valueOf(request.getBody().get("login"));//логин из реквеста
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
