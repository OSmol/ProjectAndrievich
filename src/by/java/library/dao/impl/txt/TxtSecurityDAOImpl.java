package library.dao.impl.txt;

import library.bean.Book;
import library.bean.Security;
import library.dao.SecurityDAO;
import library.dao.exception.DAOException;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TxtSecurityDAOImpl implements SecurityDAO {

    private static final String BOOKFILE = "src/by/resources/library/Data.txt";
    private static Logger logger = Logger.getLogger(TxtSecurityDAOImpl.class);

    @Override
    public Map<String, String> registerUser(Security security) {
        String login = security.getLogin();
        String password = security.getPassword();
        Map<String, String> map = new HashMap<>();
        map.put(login, password);

        return map;
    }

    private Object readFile() throws DAOException {
        File file = new File(BOOKFILE);
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
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
                    logger.info("Error");
                }
            }
        }
    }

    private void writeFile(Security security) throws DAOException {
        File file = new File(BOOKFILE);
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(security);

        } catch (NotSerializableException e) {
            throw new DAOException("file don't suggesting serialization" + e);
        } catch (IOException e) {
            throw new DAOException("file cant be create" + e);
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    //
                }
            }
        }
    }

}
