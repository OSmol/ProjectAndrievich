package library.service.factory;

import library.service.impl.BookServiceImpl;
import library.service.impl.PersonServiceImpl;
import library.service.impl.SecurityServiceImpl;
import library.service.impl.UserServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final UserServiceImpl UserServiceImpl = library.service.impl.UserServiceImpl.getInstance();
    private final BookServiceImpl BookServiceImpl = library.service.impl.BookServiceImpl.getInstance();
    private final PersonServiceImpl PersonServiceImpl = library.service.impl.PersonServiceImpl.getInstance();
    private final SecurityServiceImpl securityServiceImpl = SecurityServiceImpl.getInstance();


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
