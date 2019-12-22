package library.service;

import library.bean.Genre;
import library.service.exception.ServiceException;

import java.util.List;

public interface GenreService {
    List<Genre> getAll() throws ServiceException;
}
