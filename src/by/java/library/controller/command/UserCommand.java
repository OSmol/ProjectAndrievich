package library.controller.command;

import library.controller.Request;
import library.controller.Response;
import library.controller.command.impl.*;

public class UserCommand implements Command {
    @Override
    public Response execute(Request request) {
        request.getBody().put(6, new FindBookByAuthorCommand());
        request.getBody().put(7, new FindBookByGenreCommand());
        request.getBody().put(8, new FindBookByNameCommand());
        request.getBody().put(9, new GetBookCommand());
        request.getBody().put(10, new GetBooksCommand());
        request.getBody().put(13, new RegistrationCommand());
        request.getBody().put(14, new SignInCommand());
        request.getBody().put(15, new SignOutCommand());
        request.getBody().put(16, new SortBookByNameCommand());
        request.getBody().put(17, new SortBookByRatingCommand());
        request.getBody().put(18, new SortBookByYearCommand());

        Response response = new Response();
        return response;
    }
}
