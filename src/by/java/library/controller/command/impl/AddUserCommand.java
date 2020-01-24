package library.controller.command.impl;


import library.bean.User;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

public class AddUserCommand implements Command {
    private static Logger logger = Logger.getLogger(AddBookCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Response execute(Request request) {
        //  String id = parameters.get("id");
        String login = String.valueOf(request.getBody().get("login"));
        String password = String.valueOf(request.getBody().get("password"));
        String name = String.valueOf(request.getBody().get("name"));
        String email = String.valueOf(request.getBody().get("email"));
        String locale = String.valueOf(request.getBody().get("locale"));
        String userRole = String.valueOf(request.getBody().get("userRole"));


        Response response = new Response();
        if (login == null || login.isEmpty()
                || password == null || password.isEmpty()
                || name == null || name.isEmpty()
                || email == null || email.isEmpty()
                || locale == null || locale.isEmpty()
                || userRole == null || userRole.isEmpty()) {
            response.setErrorMessage("Enter login and password");
            response.setResponseCode(403);
            return response;
        }
        User user = new User();
        //   user.setId(Integer.parseInt(id));
        user.setName(name);
        user.setEmail(null);
        user.setLocale(locale);
        user.setUserRole(null);

        try {
            serviceFactory.getUserServiceImpl().addUser(user);
            response.setResponseCode(201);
            return response;

        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}
