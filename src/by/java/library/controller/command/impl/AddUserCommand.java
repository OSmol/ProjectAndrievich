package library.controller.command.impl;


import library.bean.Email;
import library.bean.User;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class AddUserCommand implements Command {
    private static Logger logger = Logger.getLogger(AddBookCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Response execute(Request request) {
        //  String id = parameters.get("id");
        String login = request.getStringValue("login");
        String password = request.getStringValue("password");
        String name = request.getStringValue("name");
        String email = request.getStringValue("email");
        String locale = request.getStringValue("locale");
        // String userRole = String.valueOf(request.getBody().get("userRole"));


        Response response = new Response();
        if (StringUtils.isAnyEmpty(login, password, name, email, locale)) {
            response.setErrorMessage("Empty field to add User");
            response.setResponseCode(400);
            return response;
        }
        User user = new User();
        //   user.setId(Integer.parseInt(id));
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(new Email(email));
        user.setLocale(locale);
       // user.setUserRole(null);

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
