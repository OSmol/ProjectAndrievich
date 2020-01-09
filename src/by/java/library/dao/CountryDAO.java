package library.dao;

import library.bean.Country;
import library.dao.exception.DAOException;

import java.util.ArrayList;
import java.util.List;

public interface CountryDAO {
    List<Country> getAll() throws DAOException;

}
