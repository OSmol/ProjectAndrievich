package library.controller;

import library.controller.command.Command;
import library.service.UserService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Response implements Command{
    private static Logger logger = Logger.getLogger(Response.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Map<Object, Object> execute(Map<String, String> parameters) {
        UserService userService = serviceFactory.getUserServiceImpl();
        logger.debug("response");
        String command = parameters.get("login");
        return null;
    }
}

