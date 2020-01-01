package library.service.impl.txt;

import library.bean.*;
import library.dao.BookDAO;
import library.dao.exception.DAOException;
import library.dao.factory.DAOFactory;
import library.service.BookService;
import library.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TxtBookServiceImpl implements BookService {
    private static Logger logger = Logger.getLogger(TxtBookServiceImpl.class);
    private final DAOFactory daoFactory = DAOFactory.getInstance();

    @Override
    public void addBook(String title, Person author, String publishingHouse, int year, Set<Genre> genres,
                        Set<Country> countries, long isbn, int countOfPages, String language, Person authorOfTranslation,
                        String description, double price) throws ServiceException {
        Book book = new Book();
        BookDAO bookDAO1 = daoFactory.getTxtBookDAO();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublishingHouse(publishingHouse);
        book.setYear(year);
        book.setGenres(genres);
        book.setCountries(countries);
        book.setIsbn(isbn);
        book.setCountOfPages(countOfPages);
        book.setLanguage(language);
        book.setAuthorOfTranslation(authorOfTranslation);
        book.setDescription(description);
        book.setPrice(price);

    }

    @Override
    public void editBook(String title, Person author, String publishingHouse, int year, Set<Genre> genres,
                         Set<Country> countries, long isbn, int countOfPages, String language,
                         Person authorOfTranslation, String description, double price)
            throws ServiceException {
        Book book = new Book();
        BookDAO bookDAO1 = daoFactory.getTxtBookDAO();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublishingHouse(publishingHouse);
        book.setYear(year);
        book.setGenres(genres);
        book.setCountries(countries);
        book.setIsbn(isbn);
        book.setCountOfPages(countOfPages);
        book.setLanguage(language);
        book.setAuthorOfTranslation(authorOfTranslation);
        book.setDescription(description);
        book.setPrice(price);
    }

    @Override
    public Book getBook(String idBook) throws ServiceException, DAOException {
        Book book;
        try {
            int id = Integer.parseInt(idBook);
            book = daoFactory.getTxtBookDAO().getBook(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return book;
    }

    @Override
    public List<Book> findBookByName(String nameBook) throws ServiceException {
        List<Book> list = new ArrayList<>();
        for (Book book : list) {
            //
        }
        return list;
    }

    @Override
    public List<Book> findBookByAuthor(String authorBook) throws ServiceException {
        List<Book> list = new ArrayList<>();
        //   for (Book book : this.getBook()) {
        //       String authorNameBook = book.getAuthor();
        //       if (authorNameBook.equalsIgnoreCase(authorBook)) {
        //          list.add(book);
        //     }
        //   }
        return list;
    }


    @Override
    public List<Book> findBookByGenre(String genre) throws ServiceException {
        List<Book> list = new ArrayList<>();
     /*   for (book:getBook().getGenres(){
            Set<Genre> genreName = book.getGenres();
            if (Objects.equals(genreName, genre)){
                list.add(book);
            }
        }*/
        return list;
    }


    @Override
    public List<Book> sortBookByName(String nameBook) throws ServiceException {
        List<Book>list=null;


        return list;

    }

    @Override
    public List<Book> sortBookByDate(String date) throws ServiceException {
        return null;
    }

    @Override
    public List<Book> sortBookByRating(String averageMark) throws ServiceException {
        return null;
    }
}
