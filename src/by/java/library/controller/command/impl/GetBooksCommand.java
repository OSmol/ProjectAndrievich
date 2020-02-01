package library.controller.command.impl;

import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.BookService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

public class GetBooksCommand implements Command {
    private static Logger logger = Logger.getLogger(GetBooksCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Response execute(Request request) {//
        Response response = new Response();
        BookService bookService = serviceFactory.getBookServiceImpl();
        try {
            logger.debug(request.getBody().put("list", bookService.getBooks() + "go to show all books"));
            response.setResponseCode(201);
            response.getBody().put("list", bookService.getBooks());
            logger.debug(request.getBody().put("list", bookService.getBooks() + " show all books"));
            return response;
        } catch (ServiceException e) {
            logger.error(e);
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}