package library.controller.command.impl;

import library.bean.Book;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.BookService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class GetBookCommand implements Command {
    private static Logger logger = Logger.getLogger(GetBookCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();


    @Override
    public Response execute(Request request) {
        String login = String.valueOf(request.getBody().get("login"));
        String password = String.valueOf(request.getBody().get("password"));
        Response response = new Response();
        if (StringUtils.isAnyEmpty(login, password)) {
            response.setErrorMessage("Empty fields to add Book");
            response.setResponseCode(400);
            return response;
        }

        try {
            Book book = new Book();
            BookService bookService = serviceFactory.getBookServiceImpl();
            bookService.getBook(book.getId());
            response.setResponseCode(201);
            return response;

        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}

