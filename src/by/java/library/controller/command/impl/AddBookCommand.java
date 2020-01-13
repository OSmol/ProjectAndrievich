package library.controller.command.impl;

import library.bean.Book;
import library.bean.Person;
import library.bean.User;
import library.controller.Response;
import library.controller.command.Command;
import library.service.BookService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.Map;

public class AddBookCommand implements Command {
    private static Logger logger = Logger.getLogger(SignInCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Response execute(Map<String, String> parameters) {
        String bookName = parameters.get("name");
        String authorName = parameters.get("authorName");
        String authorSurname = parameters.get("authorSurname");
        int year = Integer.parseInt(parameters.get("year"));
        Response response = new Response();
        if (bookName == null || authorName == null || bookName.isEmpty() || authorName.isEmpty() || authorSurname==null || authorSurname.isEmpty()) {
            response.setErrorMessage("Enter login and password");
            response.setResponseCode(403);
            return response;
        }
        Book book = new Book();
        book.setTitle(bookName);
        book.setYear(year);
        book.setAuthor(new Person(1, authorName, authorSurname));

        try {
            serviceFactory.getBookServiceImpl().addBook(book);
            response.setResponseCode(201);
            return response;

        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}
