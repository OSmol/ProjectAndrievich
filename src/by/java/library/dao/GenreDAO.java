package library.dao;

import library.bean.Genre;
import library.dao.exception.DAOException;

import java.util.List;

public interface GenreDAO {
    List<Genre> getAll() throws DAOException;
}
