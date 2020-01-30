package library.controller.command.impl;

import library.bean.User;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.security.PasswordEncryptor;
import library.security.PasswordEncryptorImpl;
import library.security.SecurityContextHolder;
import library.service.UserService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class RegistrationCommand implements Command {
    private static Logger logger = Logger.getLogger(RegistrationCommand.class);
    private UserService userService = ServiceFactory.getInstance().getUserServiceImpl();

    @Override
    public Response execute(Request request) {
        String login = String.valueOf(request.getBody().get("login"));
        String password = String.valueOf(request.getBody().get("password"));
        String name = String.valueOf(request.getBody().get("name"));
        Response response = new Response();
        if (StringUtils.isAnyEmpty(login, password, name)) {
            response.setErrorMessage("Empty fields");
            response.setResponseCode(400);
            return response;
        }
        PasswordEncryptor passwordEncryptor = new PasswordEncryptorImpl();
        String encryptedPassword = passwordEncryptor.encrypt(password);//зашифровать
        //и сохрнить в файл, положить в юзера
        User user;
        try {
            user = userService.findUserByLogin(login);
            if (user != null) {
                response.setResponseCode(403);
                response.setErrorMessage("User with this login already exist");
            }
            if (user == null) {
                User user1 = new User();
                user1.setName(name);
                SecurityContextHolder.setLoggedUser(user1);
                response.setResponseCode(201);//
                try {
                    userService.addUser(user1);
                } catch (ServiceException e) {
                    //
                }
            }
        } catch (ServiceException e) {
            //постар исп 1 трай и много ретурнов где они нужны в этом классе
        }
        return response;
    }
}


