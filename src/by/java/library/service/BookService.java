package library.service;

import library.bean.Book;
import library.service.exception.ServiceException;

public interface BookService {
    void addNewBook(Book book) throws ServiceException;

}
