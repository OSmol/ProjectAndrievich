package library.controller.command.impl;

import library.bean.Book;
import library.bean.User;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.BookService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.List;

public class FindBookByGenreCommand implements Command {
    private static Logger logger = Logger.getLogger(FindBookByNameCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private User.Security security = new User.Security();

    @Override
    public Response execute(Request request) {
        Response response = new Response();
        try {
            String genre = String.valueOf(request.getBody().get("genre"));
            BookService bookService = serviceFactory.getBookServiceImpl();
            List<Book> list = bookService.findBookByGenre(genre);
            System.out.println(list);
            return response;
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}

