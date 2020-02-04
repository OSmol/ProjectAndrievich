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

public class SignInCommand implements Command {
    private static Logger logger = Logger.getLogger(SignInCommand.class);
    private UserService userService = ServiceFactory.getInstance().getUserServiceImpl();

    @Override
    public Response execute(Request request) {
        String login = request.getStringValue("login");
        String password = request.getStringValue("password");
        Response response = new Response();
        if (StringUtils.isAnyEmpty(login, password)) {
            response.setErrorMessage("Empty fields");
            response.setResponseCode(400);
            return response;
        }
        User user;
        try {
            user = userService.findUserByLoginAndPassword(login, password);
            if (user != null) {
                response.setResponseCode(201);
                if (!user.getPassword().equals("admin")) {
                    response.setResponseCode(401);//
                    response.setErrorMessage("you are user");
                }
            }
            if (user == null) {
                response.setResponseCode(403);//
                response.setErrorMessage("Not found user");
            }
        } catch (ServiceException e) {
            response.setResponseCode(501);//todo
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }
}
