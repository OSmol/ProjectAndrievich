package library.service.impl.sql;

import library.bean.Person;
import library.service.PersonService;
import library.service.exception.ServiceException;

import java.util.List;

public class SQLPersonServiceImpl implements PersonService {
    @Override
    public List<Person> getAll() throws ServiceException {
        return null;
    }
}
