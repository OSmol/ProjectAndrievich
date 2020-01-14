package library.controller.command.impl;

import library.bean.Book;
import library.bean.User;
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
    public Response execute(Map<String, String> parameters) throws ServiceException {
        logger.debug("SortBookByNameCommand");
        BookService bookService = serviceFactory.getBookServiceImpl();

        String title = parameters.get("title");
        List<Book> list = bookService.sortBookByName();

        Response response = new Response();
        if (list == null || list.isEmpty()) {
            response.setErrorMessage("Enter login and password");
            response.setResponseCode(403);
            return response;
        }
        Book book = new Book();
        list.set(1, book);

        response.setResponseCode(201);
        return response;

    }
}
