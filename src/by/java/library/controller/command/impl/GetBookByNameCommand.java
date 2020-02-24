package library.controller.command.impl;

import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.BookService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;

public class GetBookByNameCommand implements Command {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static GetBookByNameCommand instance;

    private GetBookByNameCommand() {
    }

    public static synchronized GetBookByNameCommand getInstance() {
        if (instance == null) {
            instance = new GetBookByNameCommand();
        }
        return instance;
    }
    @Override
    public Response execute(Request request) {
        Response response = new Response();
        String title = request.getStringValue("title");
        BookService bookService = serviceFactory.getBookServiceImpl();
        try {
            response.getBody().put("list", bookService.findBookByName(title));
            response.setResponseCode(201);
            return response;
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());// не отправляй сообщения от исключения кому-нибудь - это тайна
            response.setResponseCode(501);
            return response;
        }
    }
}

