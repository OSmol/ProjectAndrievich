package library.dao;

import library.dao.exception.DAOException;

import java.util.List;

public interface PersonDAO {
    List<PersonDAO> getAll()throws DAOException;
}
