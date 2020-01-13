package library.controller.command.impl;

import library.bean.Book;
import library.controller.Response;
import library.controller.command.Command;
import library.service.BookService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.Map;

public class AddBookCommand implements Command {
    private static Logger logger = Logger.getLogger(AddBookCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Response execute(Map<String, String> parameters) throws ServiceException {
        BookService bookService = serviceFactory.getBookServiceImpl();

        return null;
    }
}
