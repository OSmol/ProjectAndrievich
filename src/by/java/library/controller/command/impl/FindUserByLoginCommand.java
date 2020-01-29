package library.controller.command.impl;

import library.bean.User;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.UserService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
@Deprecated
public class FindUserByLoginCommand implements Command {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Response execute(Request request) {
        Response response = new Response();
        try {
            String login = String.valueOf(request.getBody().get("login"));
            UserService userService = serviceFactory.getUserServiceImpl();
            User user = userService.findUserByLogin(login);
            System.out.println(user);
            return response;
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}
