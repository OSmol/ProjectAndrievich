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

public class FindBookByNameCommand implements Command {
    private static Logger logger = Logger.getLogger(FindBookByNameCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private User.Security security = new User.Security();
    Book book = new Book();

    @Override
    public Response execute(Request request) {
       String title= String.valueOf(request.getBody().get(book.getTitle()));
        Response response = new Response();
        if (title == null || title.isEmpty()) {
            response.setErrorMessage("Enter title");

            try {
                book.setTitle(title);
                BookService bookService = serviceFactory.getBookServiceImpl();
                response.setResponseCode(201);
                response.getBody().put("list", bookService.findBookByName(title));
                return response;

            } catch (ServiceException e) {
                response.setErrorMessage(e.getMessage());
                response.setResponseCode(501);
                return response;
            }
        }
       return response;
    }
}
