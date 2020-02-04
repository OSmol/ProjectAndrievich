package library.controller.command.impl;


import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.BookService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;

public class DeleteBookByIdCommand implements Command {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static DeleteBookByIdCommand instance;

    private DeleteBookByIdCommand() {
    }

    public static synchronized DeleteBookByIdCommand getInstance() {
        if (instance == null) {
            instance = new DeleteBookByIdCommand();
        }
        return instance;
    }
    @Override
    public Response execute(Request request) {
        Response response = new Response();
        String id = request.getStringValue("id");
        try {
            BookService bookService = serviceFactory.getBookServiceImpl();
            int num = Integer.parseInt(id);
            bookService.deleteBookById(num);
            response.setResponseCode(201);
            return response;
        } catch (ServiceException | NumberFormatException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}
