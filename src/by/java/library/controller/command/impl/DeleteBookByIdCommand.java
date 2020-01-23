package library.controller.command.impl;

import javatrDay5.helper.ScannerHelper;
import library.bean.Book;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.BookService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;

import java.util.List;

public class DeleteBookByIdCommand implements Command {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Response execute(Request request) {
        Response response = new Response();
        try {
            System.out.println("Enter id book: ");
            int id = ScannerHelper.inputInt();
            BookService bookService = serviceFactory.getBookServiceImpl();
            bookService.deleteBookById(id);
            return response;
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}
