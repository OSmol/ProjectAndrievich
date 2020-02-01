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
@Deprecated
public class GetBookByGenreCommand implements Command {
    private static Logger logger = Logger.getLogger(GetBookByNameCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();


    @Override
    public Response execute(Request request) {
        Response response = new Response();
        try {
            String genre = request.getStringValue("genre");
            BookService bookService = serviceFactory.getBookServiceImpl();
            List<Book> list = bookService.findBookByGenre(genre);
            response.getBody().put("list", bookService.getBooks());//передать лист в респонс
            return response;
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}

