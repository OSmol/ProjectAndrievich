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
        String id = request.getStringValue("id");
        String title = request.getStringValue("title");
        String author = request.getStringValue("author");
        String publishingHouse = request.getStringValue("publishingHouse");
        String year = request.getStringValue("year");
        String genre = request.getStringValue("genre");
        String country = request.getStringValue("country");
        String isbn = request.getStringValue("isbn");
        String countOfPages = request.getStringValue("countOfPages");
        String language = request.getStringValue("language");
        String authorOfTranslation = request.getStringValue("authorOfTranslation");
        String description = request.getStringValue("description");
        String price = request.getStringValue("price");

        Response response = new Response();
        if (StringUtils.isAnyEmpty(id, title, author, publishingHouse, year, genre, country, isbn, countOfPages,
                language, authorOfTranslation, description, price)) {
            response.setErrorMessage("Empty field to add Books");
            response.setResponseCode(400);
            return response;
        }
        Book book = new Book();
        try {
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
            serviceFactory.getBookServiceImpl().updateBook(book);
            response.setResponseCode(201);
            return response;

        } catch (ServiceException | NumberFormatException e) {
            response.setErrorMessage(e.getMessage());
            response.setResponseCode(501);
            return response;
        }
    }
}
