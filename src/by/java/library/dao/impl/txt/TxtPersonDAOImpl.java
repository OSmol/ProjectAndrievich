package library.dao.impl.txt;

import library.bean.Book;
import library.bean.Person;
import library.dao.PersonDAO;
import library.dao.exception.DAOException;
import library.dao.factory.DAOFactory;
import library.service.impl.BookServiceImpl;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtPersonDAOImpl implements PersonDAO {
    private static final String BOOKFILE = "src/by/resources/library/Input.txt";
    private static Logger logger = Logger.getLogger(BookServiceImpl.class);
    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private static TxtPersonDAOImpl instance;

    private TxtPersonDAOImpl() {
    }

    public static synchronized TxtPersonDAOImpl getInstance() {
        if (instance == null) {
            instance = new TxtPersonDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Person> getAll() throws DAOException {
        File file = new File(BOOKFILE);
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<Person>) objectInputStream.readObject();

        } catch (ClassNotFoundException ce) {
            throw new DAOException("Класс не существует", ce);
        } catch (FileNotFoundException e) {
            throw new DAOException("Файл для десериализации не существует: ", e);
        } catch (InvalidClassException ioe) {
            throw new DAOException("Несовпадение версий классов: ", ioe);
        } catch (IOException ioe) {
            throw new DAOException("Общая IO ошибка: ", ioe);
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();

                } catch (IOException e) {
                    System.err.println("ошибка закрытия потока ");
                }
            }
        }

    }
}
