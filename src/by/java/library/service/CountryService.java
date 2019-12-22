package library.service;

import library.bean.Country;
import library.service.exception.ServiceException;

import java.util.List;

public interface CountryService {
    List<Country> getAll() throws ServiceException;
}
