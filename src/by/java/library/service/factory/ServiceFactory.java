package library.service.factory;

import library.service.impl.BookServiceImpl;
import library.service.impl.PersonServiceImpl;
import library.service.impl.UserServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final library.service.impl.UserServiceImpl UserServiceImpl = new UserServiceImpl();
    private final library.service.impl.BookServiceImpl BookServiceImpl = new BookServiceImpl();

    private final library.service.impl.PersonServiceImpl PersonServiceImpl = new PersonServiceImpl();


    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserServiceImpl getUserServiceImpl() {
        return UserServiceImpl;
    }

    public BookServiceImpl getBookServiceImpl() {
        return BookServiceImpl;
    }

    public PersonServiceImpl getPersonServiceImpl() {
        return PersonServiceImpl;
    }
}
