package library.controller.command;

import library.service.exception.ServiceException;

import java.util.Map;
import java.util.Objects;

public interface Command {
    Map<Object, Object> execute(Map<String, String> parameters) throws ServiceException;
}
/*

 */