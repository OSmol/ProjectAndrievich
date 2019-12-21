package library.service;

import library.bean.Book;
import library.service.exception.ServiceException;

public interface LibraryService {
    void addNewBook(Book book) throws ServiceException;
    void addEditedBook(Book book) throws ServiceException;
}
