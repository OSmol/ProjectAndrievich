package library.controller.command.impl;

import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.BookService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

public class GetBooksByGenreCommand implements Command {
    private static Logger logger = Logger.getLogger(GetBookByNameCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static GetBooksByGenreCommand instance;

    private GetBooksByGenreCommand() {
    }

    public static synchronized GetBooksByGenreCommand getInstance() {
        if (instance == null) {
            instance = new GetBooksByGenreCommand();
        }
        return instance;
    }

    @Override
    public Response execute(Request request) {
        Response response = new Response();
        String genre = request.getStringValue("genre");
        BookService bookService = serviceFactory.getBookServiceImpl();
        try {
            response.getBody().put("list", bookService.findBookByGenre(genre));
            response.setResponseCode(201);
            return response;
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}

