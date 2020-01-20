package library.controller.command.impl;

import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.exception.ServiceException;

public class GetUserByLoginCommand implements Command {
    @Override
    public Response execute(Request request) throws ServiceException {
        return null;
    }
}
