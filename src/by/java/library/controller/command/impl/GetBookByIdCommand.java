package library.controller.command.impl;

import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.BookService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

public class GetBookByIdCommand implements Command {
    private static Logger logger = Logger.getLogger(GetBookByIdCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    private static GetBookByIdCommand instance;

    private GetBookByIdCommand() {
    }

    public static synchronized GetBookByIdCommand getInstance() {
        if (instance == null) {
            instance = new GetBookByIdCommand();
        }
        return instance;
    }
    @Override
    public Response execute(Request request) {
        Response response = new Response();
        BookService bookService = serviceFactory.getBookServiceImpl();

        try {
            int id = Integer.parseInt(request.getStringValue("id"));
            response.getBody().put("book", bookService.getBook(id));
            response.setResponseCode(201);
            return response;

        } catch (ServiceException | NumberFormatException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}

