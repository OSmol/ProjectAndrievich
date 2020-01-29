package library.controller.command.impl;

import library.bean.Book;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class UpdateBookCommand implements Command {
    private static Logger logger = Logger.getLogger(AddBookCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Response execute(Request request) {
        String id = String.valueOf(request.getBody().get("id"));
        String title = String.valueOf(request.getBody().get("title"));
        String author = String.valueOf(request.getBody().get("author"));
        String publishingHouse = String.valueOf(request.getBody().get("publishingHouse"));
        String year = String.valueOf(request.getBody().get("year"));
        String genre = String.valueOf(request.getBody().get("genre"));
        String country = String.valueOf(request.getBody().get("country"));
        String isbn = String.valueOf(request.getBody().get("isbn"));
        String countOfPages = String.valueOf(request.getBody().get("countOfPages"));
        String language = String.valueOf(request.getBody().get("language"));
        String authorOfTranslation = String.valueOf(request.getBody().get("authorOfTranslation"));
        String description = String.valueOf(request.getBody().get("description"));
        String averageMark = String.valueOf(request.getBody().get("averageMark"));
        String price = String.valueOf(request.getBody().get("price"));

        Response response = new Response();
        if (StringUtils.isAnyEmpty(id, title, author, publishingHouse, year, genre, country, isbn, countOfPages,
                language, authorOfTranslation, description, price)) {
            response.setErrorMessage("Empty field to add Books");
            response.setResponseCode(400);
            return response;
        }
        Book book = new Book();
        book.setId(Integer.parseInt(id));
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublishingHouse(publishingHouse);
        book.setYear(Integer.parseInt(year));
        book.setGenre(genre);
        book.setCountry(country);
        book.setIsbn(Long.parseLong(isbn));
        book.setCountOfPages(Integer.parseInt(countOfPages));
        book.setLanguage(language);
        book.setAuthorOfTranslation(authorOfTranslation);
        book.setDescription(description);

        book.setPrice(Double.parseDouble(price));
        try {
            Book book1 = new Book();
            serviceFactory.getBookServiceImpl().updateBook(book);
            response.setResponseCode(201);
            response.setBody("book1", book1);
            return response;

        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}
