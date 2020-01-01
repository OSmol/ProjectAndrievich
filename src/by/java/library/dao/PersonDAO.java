package library.dao;

import library.bean.Person;
import library.dao.exception.DAOException;

import java.util.List;

public interface PersonDAO {
    List<Person> getAll()throws DAOException;
}
