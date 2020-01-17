package library.controller.command.impl;

import library.bean.Book;
import library.bean.Person;
import library.bean.User;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.BookService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.Map;

public class UpdateBookCommand implements Command {
    private static Logger logger = Logger.getLogger(AddBookCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Response execute(Request request) {
        //  String id = parameters.get("id");
        String title = String.valueOf(request.getBody().get("title"));
        String author = String.valueOf(request.getBody().get("author"));
        String publishingHouse = String.valueOf(request.getBody().get("publishingHouse"));
        String year = String.valueOf(request.getBody().get("year"));
        // Set<Genre> genre =request.getBody().get("genre");
        //  Set<Country>country = parameters.get("country");
        String isbn = String.valueOf(request.getBody().get("isbn"));
        String countOfPages = String.valueOf(request.getBody().get("countOfPages"));
        String language = String.valueOf(request.getBody().get("language"));
        String authorOfTranslation = String.valueOf(request.getBody().get("authorOfTranslation"));
        String description = String.valueOf(request.getBody().get("description"));
        String averageMark = String.valueOf(request.getBody().get("averageMark"));
        String price = String.valueOf(request.getBody().get("price"));

        Response response = new Response();
        if (title == null || title.isEmpty()
                || author == null || author.isEmpty()
                || publishingHouse == null || publishingHouse.isEmpty()
                || year == null || year.isEmpty()
                || isbn == null || isbn.isEmpty()
                || countOfPages == null || countOfPages.isEmpty()
                || language == null || language.isEmpty()
                || authorOfTranslation == null || authorOfTranslation.isEmpty()
                || description == null || description.isEmpty()
                || averageMark == null || averageMark.isEmpty()
                || price == null || price.isEmpty()) {
            response.setErrorMessage("Enter login and password");
            response.setResponseCode(403);
            return response;
        }
        Book book = new Book();
        //   book.setId(Integer.parseInt(id));
        book.setTitle(title);
        book.setAuthor(new Person(1, author, author));
        book.setPublishingHouse(publishingHouse);
        book.setYear(Integer.parseInt(year));
        // book.setGenres(genre);
        //  book.setCountries(country);
        book.setIsbn(Long.parseLong(isbn));
        book.setCountOfPages(Integer.parseInt(countOfPages));
        book.setLanguage(language);
        book.setAuthorOfTranslation(new Person(1, authorOfTranslation, authorOfTranslation));
        book.setDescription(description);
        book.setAverageMark(Double.parseDouble(averageMark));
        book.setPrice(Double.parseDouble(price));
        try {
            serviceFactory.getBookServiceImpl().updateBook(book);
            response.setResponseCode(201);
            return response;

        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}
