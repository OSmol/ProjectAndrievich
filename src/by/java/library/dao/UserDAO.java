package library.dao;

import library.bean.User;
import library.dao.exception.DAOException;

import java.util.List;

/*
слой доступа к данным

название методов должно отображать работу с файлом, так как на Дао я работаю с файлом.
названия методов не должны отображать бизнес логику (сервис)
 */
public interface UserDAO {
    List<User> getUsers() throws DAOException;

    void add(User user) throws DAOException;

    void delete(String login) throws DAOException;

    boolean delete(User user) throws DAOException;

    User get(String login) throws DAOException;

    void update(User user) throws DAOException;

}
