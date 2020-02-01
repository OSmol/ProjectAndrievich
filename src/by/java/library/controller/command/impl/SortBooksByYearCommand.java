package library.controller.command.impl;

import library.bean.Book;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.BookService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.List;

public class SortBooksByYearCommand implements Command {
    private static Logger logger = Logger.getLogger(SignInCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Response execute(Request request) {
        logger.debug("SortBooksByYearCommand");
        BookService bookService = serviceFactory.getBookServiceImpl();
        List<Book> list = null;
        try {
            list = bookService.sortBookByYear();
        } catch (ServiceException e) {
            //  log
        }
        Response response = new Response();
        if (list == null || list.isEmpty()) {
            response.setErrorMessage("Empty field to sort Books");
            response.setResponseCode(400);
            return response;
        }
        response.setResponseCode(201);
        response.getBody().put("title", list);
        return response;
    }
}

