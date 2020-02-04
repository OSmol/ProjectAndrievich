package library.controller.command.impl;

import library.bean.Book;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.dao.impl.txt.TxtUserDAOImpl;
import library.service.BookService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;

import java.util.List;

public class SortBooksByNameCommand implements Command {
    private static Logger logger = Logger.getLogger(SignInCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static SortBooksByNameCommand instance;

    private SortBooksByNameCommand() {
    }

    public static synchronized SortBooksByNameCommand getInstance() {
        if (instance == null) {
            instance = new SortBooksByNameCommand();
        }
        return instance;
    }

    @Override
    public Response execute(Request request) {
        logger.debug("SortBooksByNameCommand");
        Response response = new Response();
        BookService bookService = serviceFactory.getBookServiceImpl();
        List<Book> list;
        try {
            list = bookService.sortBookByName();
            if (CollectionUtils.isEmpty(list)) {
                response.setErrorMessage("Empty field to add Books");
                response.setResponseCode(400);
                return response;
            }
            response.setResponseCode(201);
            response.getBody().put("title", list);
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }
}
