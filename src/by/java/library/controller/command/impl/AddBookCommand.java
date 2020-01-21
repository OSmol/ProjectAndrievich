package library.controller.command.impl;

import library.bean.Book;
import library.bean.Person;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;


public class AddBookCommand implements Command {
    private static Logger logger = Logger.getLogger(AddBookCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public Response execute(Request request) {
        //  String id = parameters.get("id");
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
        //  String averageMark = String.valueOf(request.getBody().get("averageMark"));
        String price = String.valueOf(request.getBody().get("price"));

        Response response = new Response();
        if (title == null || title.isEmpty()
                || author == null || author.isEmpty()
                || publishingHouse == null || publishingHouse.isEmpty()
                || year == null || year.isEmpty()
                || genre == null || genre.isEmpty()
                || country == null || country.isEmpty()
                || isbn == null || isbn.isEmpty()
                || countOfPages == null || countOfPages.isEmpty()
                || language == null || language.isEmpty()
                || authorOfTranslation == null || authorOfTranslation.isEmpty()
                || description == null || description.isEmpty()

                || price == null || price.isEmpty()) {
            response.setErrorMessage("Enter login and password");
            response.setResponseCode(403);
            return response;
        }
        Book book = new Book();
        //   book.setId(Integer.parseInt(id));
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
