package library.controller.command.impl;

import library.bean.*;
import library.controller.Response;
import library.controller.command.Command;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;
import java.util.Map;


public class AddBookCommand implements Command {
    private static Logger logger = Logger.getLogger(AddBookCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Response execute(Map<String, String> parameters) {
        //  String id = parameters.get("id");
        String title = parameters.get("title");
        String author = parameters.get("author");
        String publishingHouse = parameters.get("publishingHouse");
        String year = parameters.get("year");
        //   Set<Genre> genre = parameters.get("genre");
        //  Set<Country>country = parameters.get("country");
        String isbn = parameters.get("isbn");
        String countOfPages = parameters.get("countOfPages");
        String language = parameters.get("language");
        String authorOfTranslation = parameters.get("authorOfTranslation");
        String description = parameters.get("description");
        String averageMark = parameters.get("averageMark");
        String price = parameters.get("price");

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
