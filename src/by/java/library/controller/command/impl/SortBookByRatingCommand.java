package library.controller.command.impl;

import library.bean.Book;
import library.bean.User;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

public class SortBookByRatingCommand implements Command {
    private static Logger logger = Logger.getLogger(SignInCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private User.Security security = new User.Security();
    private Book book = new Book();

    @Override
    public Response execute(Request request) {
        return null;

    }
}
