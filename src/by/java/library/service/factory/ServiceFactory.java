package library.service.factory;

import library.service.*;
import library.service.impl.sql.*;
import library.service.impl.txt.*;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final SQLUserServiceImpl sqlUserService = new SQLUserServiceImpl();
    private final SQLBookServiceImpl sqlBookService = new SQLBookServiceImpl();
    private final SQLGenreServiceImpl sqlGenreService = new SQLGenreServiceImpl();
    private final SQLCountryServiceImpl sqlCountryService = new SQLCountryServiceImpl();
    private final SQLPersonServiceImpl sqlPersonService = new SQLPersonServiceImpl();

    private final TxtUserServiceImpl txtUserService = new TxtUserServiceImpl();
    private final TxtBookServiceImpl txtBookService = new TxtBookServiceImpl();
    private final TxtGenreServiceImpl txtGenreService = new TxtGenreServiceImpl();
    private final TxtCountryServiceImpl txtCountryService = new TxtCountryServiceImpl();
    private final TxtPersonServiceImpl txtPersonService = new TxtPersonServiceImpl();


    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public SQLUserServiceImpl getSqlUserService() {
        return sqlUserService;
    }

    public SQLBookServiceImpl getSqlBookService() {
        return sqlBookService;
    }

    public SQLGenreServiceImpl getSqlGenreService() {
        return sqlGenreService;
    }

    public SQLCountryServiceImpl getSqlCountryService() {
        return sqlCountryService;
    }

    public SQLPersonServiceImpl getSqlPersonService() {
        return sqlPersonService;
    }

    public TxtUserServiceImpl getTxtUserService() {
        return txtUserService;
    }

    public TxtBookServiceImpl getTxtBookService() {
        return txtBookService;
    }

    public TxtGenreServiceImpl getTxtGenreService() {
        return txtGenreService;
    }

    public TxtCountryServiceImpl getTxtCountryService() {
        return txtCountryService;
    }

    public TxtPersonServiceImpl getTxtPersonService() {
        return txtPersonService;
    }
}
