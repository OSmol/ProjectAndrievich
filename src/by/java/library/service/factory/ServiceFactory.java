package library.service.factory;

import library.service.CountryService;
import library.service.GenreService;
import library.service.UserService;
import library.service.BookService;
import library.service.impl.CountryServiceImpl;
import library.service.impl.GenreServiceImpl;
import library.service.impl.UserServiceImpl;
import library.service.impl.BookServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final UserService userService = new UserServiceImpl();
    private final BookService bookService = new BookServiceImpl();
    private final GenreService genreService = new GenreServiceImpl();
    private final CountryService countryService = new CountryServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public GenreService getGenreService() {
        return genreService;
    }

    public CountryService getCountryService() {
        return countryService;
    }
}
