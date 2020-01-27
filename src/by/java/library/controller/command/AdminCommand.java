package library.controller.command;

import library.controller.Request;
import library.controller.Response;
import library.controller.command.impl.*;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class AdminCommand implements Command {
    private static Logger logger = Logger.getLogger(AddBookCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private final Map<Integer, Command> map = new HashMap<>();

    @Override
    public Response execute(Request request) {
       //можно ли так сделать? или сделать каждый этот метод синглетоном и ложить в пустую мап через гетИнстансе?


            request.getBody().put(1, new AddBookCommand());
            request.getBody().put(2, new AddUserCommand());
            request.getBody().put(3, new DeleteBookByIdCommand());
            request.getBody().put(4, new DeleteBookCommand());
            request.getBody().put(5, new DeleteUserCommand());
            request.getBody().put(6, new FindBookByAuthorCommand());
            request.getBody().put(7, new FindBookByGenreCommand());
            request.getBody().put(8, new FindBookByNameCommand());
            request.getBody().put(9, new GetBookCommand());
            request.getBody().put(10, new GetBooksCommand());
            request.getBody().put(11, new GetUserByLoginCommand());
            request.getBody().put(12, new GetUsersCommand());
            request.getBody().put(13, new RegistrationCommand());
            request.getBody().put(14, new SignInCommand());
            request.getBody().put(15, new SignOutCommand());
            request.getBody().put(16, new SortBookByNameCommand());
            request.getBody().put(17, new SortBookByRatingCommand());
            request.getBody().put(18, new SortBookByYearCommand());
            request.getBody().put(19, new UpdateBookCommand());
            request.getBody().put(20, new UpdateUserCommand());

        Response response = new Response();
        return response;
    }
}
