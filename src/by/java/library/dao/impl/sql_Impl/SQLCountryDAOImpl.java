package library.dao.impl.sql_Impl;

import library.bean.Country;
import library.bean.Genre;
import library.dao.CountryDAO;
import library.dao.GenreDAO;
import library.dao.exception.DAOException;

import java.util.List;

public class SQLCountryDAOImpl implements CountryDAO{

    @Override
    public List<Country> getAll() throws DAOException {
        return null;
    }
}
