package library.controller.command;

import library.controller.Response;
import library.service.exception.ServiceException;

import java.util.Map;
import java.util.Objects;

public interface Command {//map = request
    Response execute(Map<String, String> parameters) throws ServiceException;
}
