package library.controller.command.impl;

import library.controller.Response;
import library.controller.command.Command;
import library.service.exception.ServiceException;

import java.util.Map;

public class AddBookCommand implements Command {
    @Override
    public Response execute(Map<String, String> parameters) throws ServiceException {
        return null;
    }
}
