package library.controller.command.impl;

import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.security.SecurityContextHolder;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

public class SignOutCommand implements Command {

    private static Logger logger = Logger.getLogger(SignOutCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static SignOutCommand instance;

    private SignOutCommand() {
    }

    public static synchronized SignOutCommand getInstance() {
        if (instance == null) {
            instance = new SignOutCommand();
        }
        return instance;
    }
    @Override
    public Response execute(Request request) {
        SecurityContextHolder.setLoggedUser(null);//todo
        return new Response(200);
    }
}

