package library.controller.command.impl;

import library.bean.Book;
import library.bean.Genre;
import library.bean.User;
import library.controller.Response;
import library.controller.command.Command;
import library.service.BookService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.Map;

public class FindBookByGenreCommand implements Command {
    private static Logger logger = Logger.getLogger(FindBookByNameCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private User.Security security = new User.Security();

    @Override
    public Response execute(Map<String, String> parameters) {
        String login = parameters.get("login");
        String password = parameters.get("password");
        Response response = new Response();
        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            response.setErrorMessage("Enter login and password");
            response.setResponseCode(403);
            return response;
        }
        security.setLogin(login);
        security.setPassword(password);

        try {
            Book book = new Book();
            BookService bookService = serviceFactory.getBookServiceImpl();
            bookService.findBookByGenre(new Genre());
            response.setResponseCode(201);
            return response;

        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}
