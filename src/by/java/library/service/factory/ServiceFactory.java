package library.service.factory;

import library.service.*;
import library.service.impl.*;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final UserService userService = new UserServiceImpl();
    private final BookService bookService = new BookServiceImpl();
    private final GenreService genreService = new GenreServiceImpl();
    private final CountryService countryService = new CountryServiceImpl();
    private final PersonService personService = new PersonServiceImpl();

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
    public PersonService getPersonService(){
        return personService;
    }
}
