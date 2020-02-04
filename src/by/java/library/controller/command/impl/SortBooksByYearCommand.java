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
    private static SortBooksByYearCommand instance;

    private SortBooksByYearCommand() {
    }

    public static synchronized SortBooksByYearCommand getInstance() {
        if (instance == null) {
            instance = new SortBooksByYearCommand();
        }
        return instance;
    }
    @Override
    public Response execute(Request request) {
        logger.debug("SortBooksByYearCommand");
        Response response = new Response();
        BookService bookService = serviceFactory.getBookServiceImpl();
        List<Book> list;
        try {
            list = bookService.sortBookByYear();
            if (list == null || list.isEmpty()) {
                response.setErrorMessage("Empty field to sort Books");
                response.setResponseCode(400);
                return response;
            }
            response.setResponseCode(201);
            response.getBody().put("title", list);
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }
}

