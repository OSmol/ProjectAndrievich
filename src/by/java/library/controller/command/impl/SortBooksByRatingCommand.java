package library.controller.command.impl;

import library.bean.Book;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.BookService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;

import java.util.List;

public class SortBooksByRatingCommand implements Command {
    private static Logger logger = Logger.getLogger(SignInCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Response execute(Request request) {//todo
        logger.debug("SortBooksByRatingCommand");
        Response response = new Response();
        BookService bookService = serviceFactory.getBookServiceImpl();
        List<Book> list;
        try {
            list = bookService.sortBookByRating(1);
            if (CollectionUtils.isEmpty(list)) {
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
