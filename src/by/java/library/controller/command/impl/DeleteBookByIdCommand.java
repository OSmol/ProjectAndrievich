package library.controller.command.impl;


import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.BookService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;

public class DeleteBookByIdCommand implements Command {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Response execute(Request request) {
        Response response = new Response();
        String id = String.valueOf(request.getBody().get("id"));
        try {
            BookService bookService = serviceFactory.getBookServiceImpl();
            int num = Integer.parseInt(id);
            bookService.deleteBookById(num);
            return response;
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}
