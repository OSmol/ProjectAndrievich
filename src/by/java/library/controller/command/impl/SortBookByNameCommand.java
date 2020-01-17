package library.controller.command.impl;

import library.bean.Book;
import library.bean.User;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.BookService;
import library.service.SecurityService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SortBookByNameCommand implements Command {
    private static Logger logger = Logger.getLogger(SignInCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();


    @Override
    public Response execute(Request request) throws ServiceException {
        logger.debug("SortBookByNameCommand");
        BookService bookService = serviceFactory.getBookServiceImpl();


        List<Book> list = bookService.sortBookByName();

        Response response = new Response();
        if (list == null || list.isEmpty()) {
            response.setErrorMessage("Enter login and password");
            response.setResponseCode(403);
            return response;
        }
        response.setResponseCode(201);
        response.getBody().put("title", list);
        return response;

    }
}
