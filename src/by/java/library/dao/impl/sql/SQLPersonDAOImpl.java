package library.dao.impl.sql;

import library.bean.Person;
import library.dao.PersonDAO;
import library.dao.exception.DAOException;

import java.util.ArrayList;
import java.util.List;

public class SQLPersonDAOImpl implements PersonDAO {
    @Override
    public List<Person> getAll() throws DAOException {
        List<Person>list = new ArrayList<>();
        return list;
    }
}
