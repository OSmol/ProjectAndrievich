package library.controller.command.impl;

import library.bean.Book;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

public class DeleteBookCommand implements Command {
    private static Logger logger = Logger.getLogger(DeleteBookCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();


    @Override
    public Response execute(Request request) {
        Book book = (Book) request.getBody().get("book");
        Response response=new Response();
        try {
            serviceFactory.getBookServiceImpl().deleteBook(book);
            response.setResponseCode(201);
        }catch (ServiceException e){
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
        }
        return response;
    }
}
