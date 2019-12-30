package library.service;

import library.bean.Person;
import library.service.exception.ServiceException;

import java.util.List;

public interface PersonService {
    List<Person>getAll()throws ServiceException;
}
