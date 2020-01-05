package library.service.impl.txt;

import library.bean.*;
import library.dao.exception.DAOException;
import library.dao.factory.DAOFactory;
import library.service.BookService;
import library.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TxtBookServiceImpl implements BookService {
    private static Logger logger = Logger.getLogger(TxtBookServiceImpl.class);
    private final DAOFactory daoFactory = DAOFactory.getInstance();

    //передать бин
    @Override
    public void addBook(Book book) throws ServiceException {

    }

    @Override
    public void updateBook(Book book) throws ServiceException {

    }


    @Override
    public Book getBook(int idBook) throws ServiceException, DAOException {
        try {
            return daoFactory.getTxtBookDAO().getBook(idBook);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

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
    public List<Book> findBookByGenre(Genre genre) throws ServiceException {
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
        List<Book> list = null;


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
