package library.dao.impl.txt;

import com.sun.xml.internal.txw2.TxwException;
import library.bean.Genre;
import library.bean.Person;
import library.dao.GenreDAO;
import library.dao.exception.DAOException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtGenreDAOImpl implements GenreDAO {
    private static final String BOOKFILE = "src/by/resources/library/Input.txt";

    @Override
    public List<Genre> getAll() throws DAOException {
        File file = new File(BOOKFILE);
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<Genre>) objectInputStream.readObject();

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
