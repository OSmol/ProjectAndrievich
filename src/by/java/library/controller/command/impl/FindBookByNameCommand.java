package library.controller.command.impl;

import library.bean.Book;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.BookService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;

import java.util.List;

public class FindBookByNameCommand implements Command {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Response execute(Request request) {
        Response response = new Response();
        try {
            String title = String.valueOf(request.getBody().get("title"));
            BookService bookService = serviceFactory.getBookServiceImpl();
            List<Book> list = bookService.findBookByName(title);
            System.out.println(list);
            return response;
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}
/*
получаешь реквест, достаёщб оттуда параметры, выполняешь сервис, ложишь в ресонс
 */
