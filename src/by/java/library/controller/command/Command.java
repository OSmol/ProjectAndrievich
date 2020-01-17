package library.controller.command;
import library.controller.Request;
import library.controller.Response;
import library.service.exception.ServiceException;



public interface Command {//map = request
    Response execute(Request request) throws ServiceException;
}
