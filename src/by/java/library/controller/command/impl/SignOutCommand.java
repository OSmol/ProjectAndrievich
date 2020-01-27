package library.controller.command.impl;

import library.bean.User;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

public class SignOutCommand implements Command {

    private static Logger logger = Logger.getLogger(SignOutCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private User.Security security = new User.Security();

    @Override
    public Response execute(Request request)  {

            return null;
        }
    }

