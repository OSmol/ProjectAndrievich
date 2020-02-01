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
            String title = request.getStringValue("title");
            BookService bookService = serviceFactory.getBookServiceImpl();
            List<Book> list = bookService.findBookByName(title);
            response.getBody().put(list, bookService.getBooks());//передали лист в респонс
            return response;
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}
/*
получить реквест, достать оттуда параметры, выполнить сервис, положить в респонс
 */
